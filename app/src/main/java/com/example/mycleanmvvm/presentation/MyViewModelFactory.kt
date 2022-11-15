package com.example.mycleanmvvm.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mycleanmvvm.data.NetworkClient
import com.example.mycleanmvvm.data.repository.GetDataRepository

class MyViewModelFactory(context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(repository = GetDataRepository(networkClient = NetworkClient())) as T
    }
}