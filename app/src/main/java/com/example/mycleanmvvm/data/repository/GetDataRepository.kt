package com.example.mycleanmvvm.data.repository

import com.example.mycleanmvvm.data.api.UserApi
import com.example.mycleanmvvm.domain.mappers.task.toDomainTask
import com.example.mycleanmvvm.domain.mappers.user.toDomain
import com.example.mycleanmvvm.domain.models.TaskDomainModel
import com.example.mycleanmvvm.domain.models.UserDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class GetDataRepository(
    private val service: UserApi
) : GetDataRepositoryInterface {
    override suspend fun getUserName(id: Int): UserDomainModel {
        return service.getUser(id).toDomain()
    }

    override suspend fun getUserTask(id: Int): List<TaskDomainModel> {
        return service.getUserTask(id).map { it.toDomainTask() }
    }

//    override suspend fun getUserTask(id: Int): List<TaskDomainModel> {
//        return  withContext(Dispatchers.IO){
//            val tasks = service.getUserTask(id)
//            tasks.map { it.toDomainTask() }
//        }
//    }
}