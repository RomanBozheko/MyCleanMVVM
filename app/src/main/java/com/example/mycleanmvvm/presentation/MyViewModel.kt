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
import java.time.temporal.ValueRange

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

    suspend fun showName(id: Int) {
        val user = repository.getUserName(id)
        _nameUserMutable.tryEmit(user)
    }


    private var _tasksUserMutable = MutableSharedFlow<List<TaskDomainModel>>()
    var tasksUser: SharedFlow<List<TaskDomainModel>> = _tasksUserMutable.asSharedFlow()

    suspend fun showTasks(id: Int) {
        val tasks = repository.getUserTask(id)
        _tasksUserMutable.tryEmit(tasks)
    }


}