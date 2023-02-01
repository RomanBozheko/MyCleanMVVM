package com.example.mycleanmvvm.domain.mappers.user


import com.example.mycleanmvvm.data.api.model.UserNetworkModel
import com.example.mycleanmvvm.domain.models.UserDomainModel

fun UserNetworkModel.toDomain(): UserDomainModel {
    return UserDomainModel(
        id = this.id,
        name = this.name,
        username = this.username,
        email = this.email ?: "no email",
        address = this.address.toDomainAddress(),
        phone = this.phone ?: "",
        website = this.website ?: "",
        company = this.company?.toDomainCompany(),
    )
}

