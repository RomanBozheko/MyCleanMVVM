package com.example.mycleanmvvm.data.repository

import com.example.mycleanmvvm.data.api.model.UserNetworkModel
import com.example.mycleanmvvm.domain.models.UserDomainModel
import kotlinx.coroutines.Job

interface GetDataRepositoryInterface {
   suspend fun getUserName(id: Int): String
}