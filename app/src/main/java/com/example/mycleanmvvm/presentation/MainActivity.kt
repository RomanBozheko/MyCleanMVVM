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

        viewModel = ViewModelProvider(this, MyViewModelFactory(this)).get(MyViewModel::class.java)

        lifecycleScope.launch {
            viewModel.nameUser
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect{binding.txtRes.text = it}

        }
        val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
        coroutineScope.launch{
            viewModel.showName(9)
        }

    }



}