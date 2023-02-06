package com.example.mycleanmvvm.data.repository

import com.example.mycleanmvvm.domain.models.TaskDomainModel
import com.example.mycleanmvvm.domain.models.UserDomainModel
import retrofit2.Call
import retrofit2.Response


interface GetDataRepositoryInterface {
    suspend fun getUserName(id: Int): UserDomainModel
    suspend fun getUserTask(id: Int): List<TaskDomainModel>
}