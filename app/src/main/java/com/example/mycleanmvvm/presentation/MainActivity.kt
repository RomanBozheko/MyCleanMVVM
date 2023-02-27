package com.example.mycleanmvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.mycleanmvvm.R
import com.example.mycleanmvvm.data.repository.GetDataRepository
import com.example.mycleanmvvm.databinding.ActivityMainBinding
import com.example.mycleanmvvm.domain.models.CompanyDomainModel
import com.example.mycleanmvvm.domain.models.TaskDomainModel
import com.example.mycleanmvvm.domain.models.UserDomainModel
import kotlinx.coroutines.*
import java.lang.System.out

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "TAG_MainActivity-> "
    }

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            MyViewModelFactory()
        )[MyViewModel::class.java]


        lifecycleScope.launch {
            viewModel.nameUser
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect(this@MainActivity::setUser)

            viewModel.tasksUser
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect(this@MainActivity::setTasks)
        }
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            println("< 000 >")
            viewModel.showTasks(1)
            println("< 111 >")
            viewModel.showName(1)
        }
    }

    private fun setTasks(taskDomainModel: List<TaskDomainModel>){
        println("//////////////////////////////////////")
        if(taskDomainModel.isNotEmpty()){
            val firstTask = taskDomainModel.first()
            println(firstTask.id)
        }   else{
            println("LIST_EMPTY")
        }
        println("//////////////////////////////////////")
    }

    private fun setUser(userDomainModel: UserDomainModel) {
        binding.txtRes.text = "${userDomainModel.name} - ${userDomainModel.id}"
        binding.txtResAddr.text = userDomainModel.email

        println("==========================================")
        println(userDomainModel.id)
        println(userDomainModel.name)
        println(userDomainModel.username)
        println(userDomainModel.email)
        println(userDomainModel.address.street)
        println(userDomainModel.address.suite)
        println(userDomainModel.address.city)
        println(userDomainModel.address.zipcode)
        println("lat ${userDomainModel.address.geo.lat} :: lng ${userDomainModel.address.geo.lng}")
        println(userDomainModel.phone)
        println(userDomainModel.website)
        println(userDomainModel.company?.name)
        println(userDomainModel.company?.catchPhrase)
        println(userDomainModel.company?.bs)
        println("==========================================")
    }



}