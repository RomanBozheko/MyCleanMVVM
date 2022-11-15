package com.example.mycleanmvvm.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.mycleanmvvm.data.repository.GetDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel(val repository: GetDataRepository) : ViewModel() {


    companion object {
        const val TAG = "TAG_MyViewModel-> "
    }

    init {
        Log.d(TAG, "MyViewModel_created")
    }


    private var _nameUserMutable = MutableSharedFlow<String>(
        replay = 1,
        extraBufferCapacity = 0,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    var nameUser: SharedFlow<String> = _nameUserMutable.asSharedFlow()

    suspend fun showName(id: Int) {
        _nameUserMutable.tryEmit(repository.getUserName(id))
    }
}