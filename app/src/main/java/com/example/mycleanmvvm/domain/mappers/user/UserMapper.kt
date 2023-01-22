package com.example.mycleanmvvm.domain.mappers.user

import com.example.mycleanmvvm.data.api.model.AddressNetworkModel
import com.example.mycleanmvvm.data.api.model.UserNetworkModel
import com.example.mycleanmvvm.domain.models.AddressDomainModel
import com.example.mycleanmvvm.domain.models.UserDomainModel

fun UserNetworkModel.toDomain(): UserDomainModel{
    return UserDomainModel(
        id = this.id,
        name = this.name,
        username = this.username,
        email = this.email ?: "no email",
        address = this.address.toDomainAddress(),
        phone = this.phone ?: "",
        website = this.website ?: "",
        company = null,
    )
}

fun AddressNetworkModel?.toDomainAddress(): AddressDomainModel{
    if (this == null) return AddressDomainModel(
        street= "no address",
        suite = "",
        city= "",
        zipcode = "1234",
    )

    return AddressDomainModel(
        street= this.street ?: "no address",
        suite = this.suite?: "no suite",
        city= this.city?: "no city",
        zipcode = this.zipcode?: "no zipcode",
    )
}