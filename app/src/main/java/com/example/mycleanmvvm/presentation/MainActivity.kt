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

//        lifecycleScope.launch {
//            viewModel.tasksUser
//                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
//                .collect(this@MainActivity::setTasks)
//        }
//        lifecycleScope.launch {
//            viewModel.nameUser
//                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
//                .collect(this@MainActivity::setUser)
//        }
        lifecycleScope.launch {
            coroutineScope {
                val tasksUserJob = launch {
                    viewModel.tasksUser
                        .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                        .collect(this@MainActivity::setTasks)
                }
                val nameUserJob = launch {
                    viewModel.nameUser
                        .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                        .collect(this@MainActivity::setUser)
                }
                tasksUserJob.join()
                nameUserJob.join()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            val user = 9
            viewModel.showTasks(user)
            viewModel.showName(user)
        }
    }

    private fun setTasks(taskDomainModel: List<TaskDomainModel>) {

        if (taskDomainModel.isNotEmpty()) {
            println("Number of tasks: ${taskDomainModel.size} \n\n")
//            println(taskDomainModel[0].userId)
//            println(taskDomainModel[0].id)
//            println(taskDomainModel[0].title)
//            println(taskDomainModel[0].completed)
            for (i in taskDomainModel.indices) {
                val task = taskDomainModel[i]
                println("${i + 1} User ID: ${task.userId}")
                println("Task ID: ${task.id}")
                println("Task Title: ${task.title}")
                println("Task Completed: ${task.completed}")
                println("--------------------")
            }
        } else {
            println("LIST_EMPTY")
        }
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