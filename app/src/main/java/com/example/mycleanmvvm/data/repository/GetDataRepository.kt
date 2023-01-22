package com.example.mycleanmvvm.data.repository

import com.example.mycleanmvvm.data.api.UserApi
import com.example.mycleanmvvm.domain.mappers.user.toDomain
import com.example.mycleanmvvm.domain.models.UserDomainModel



class GetDataRepository(
    private val service: UserApi
) : GetDataRepositoryInterface {
    override suspend fun getUserName(id: Int): UserDomainModel {
        val response = service.getUser(id).toDomain()
        println(response.name)
        println("=============================")
        return response
    }

}