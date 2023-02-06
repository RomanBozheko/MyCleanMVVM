package com.example.mycleanmvvm.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.mycleanmvvm.data.repository.GetDataRepository
import com.example.mycleanmvvm.domain.models.TaskDomainModel
import com.example.mycleanmvvm.domain.models.UserDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel(private val repository: GetDataRepository) : ViewModel() {


    companion object {
        const val TAG = "TAG_MyViewModel-> "
    }

    init {
        Log.d(TAG, "MyViewModel_created")
    }


    private var _nameUserMutable = MutableSharedFlow<UserDomainModel>(
        replay = 1,
        extraBufferCapacity = 0,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    var nameUser: SharedFlow<UserDomainModel> = _nameUserMutable.asSharedFlow()

    private var _taskUserMutable = MutableSharedFlow<TaskDomainModel>(
        replay = 1,
        extraBufferCapacity = 0,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    var taskUser: SharedFlow<TaskDomainModel> = _taskUserMutable.asSharedFlow()


    suspend fun showName(id: Int) {
        val user = repository.getUserName(id)
        _nameUserMutable.tryEmit(user)
    }

    suspend fun showTask(id: Int) {
        val task = repository.getUserTask(id)
        _taskUserMutable.tryEmit(task)
    }
}