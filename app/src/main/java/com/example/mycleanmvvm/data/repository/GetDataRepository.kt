package com.example.mycleanmvvm.data.repository

import com.example.mycleanmvvm.data.NetworkClient
import com.example.mycleanmvvm.domain.models.UserDomainModel
import kotlinx.coroutines.*


class GetDataRepository(
    private val networkClient: NetworkClient
) : GetDataRepositoryInterface {
    override suspend fun getUserName(id: Int) = withContext(SupervisorJob() + Dispatchers.IO) {

        val service = networkClient.getRetrofitInstance()

        val response = service.getUser(id)
        println(response.name)
        println("=============================")
        return@withContext response.name
    }

}