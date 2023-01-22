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
import com.example.mycleanmvvm.domain.models.UserDomainModel
import kotlinx.coroutines.*

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
        }

    }
    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            viewModel.showName(1)
        }
    }

    private fun setUser(userDomainModel: UserDomainModel){
        binding.txtRes.text = userDomainModel.name
        binding.txtResAddr.text = userDomainModel.address.city

    }



}