package com.example.mycleanmvvm.data.api


import com.example.mycleanmvvm.data.api.model.TaskNetworkModel
import com.example.mycleanmvvm.data.api.model.UserNetworkModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("/users/{userId}")
    suspend fun getUser(@Path("userId") userId: Int): UserNetworkModel

    @GET("users/{userId}/todos")
    suspend fun getUserTask(@Path("userId") userId: Int): List<TaskNetworkModel>
}