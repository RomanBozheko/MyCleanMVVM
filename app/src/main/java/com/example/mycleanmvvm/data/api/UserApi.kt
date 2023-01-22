package com.example.mycleanmvvm.data.api

import com.example.mycleanmvvm.data.api.model.UserNetworkModel
import com.example.mycleanmvvm.domain.models.UserDomainModel
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("/users/{userId}")
    suspend fun getUser(@Path("userId") userId: Int):UserNetworkModel
}