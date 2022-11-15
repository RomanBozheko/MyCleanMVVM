package com.example.mycleanmvvm.domain.mappers

import com.example.mycleanmvvm.data.api.model.UserNetworkModel
import com.example.mycleanmvvm.domain.models.AddressDomainModel
import com.example.mycleanmvvm.domain.models.CompanyDomainModel
import com.example.mycleanmvvm.domain.models.UserDomainModel

fun UserNetworkModel.toDomain(): UserDomainModel{
    return UserDomainModel(
        id = (this.id ?: "") as Int,
        name = this.name ?: "",
        username = this.username ?: "",
        email = this.email ?: "",
        address = (this.address ?: "") as AddressDomainModel,
        phone = this.phone ?: "",
        website = this.website ?: "",
        company = (this.company ?: "") as CompanyDomainModel,
    )
}