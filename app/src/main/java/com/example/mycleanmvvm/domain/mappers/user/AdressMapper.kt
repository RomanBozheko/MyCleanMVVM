package com.example.mycleanmvvm.domain.mappers.user

import com.example.mycleanmvvm.data.api.model.AddressNetworkModel
import com.example.mycleanmvvm.domain.models.AddressDomainModel


fun AddressNetworkModel?.toDomainAddress(): AddressDomainModel {
    if (this == null) return AddressDomainModel(
        street = "no address",
        suite = "",
        city = "",
        zipcode = "1234",
        geo = this?.geo.toDomainGeo()
    )

    return AddressDomainModel(
        street = this.street ?: "no address",
        suite = this.suite ?: "no suite",
        city = this.city ?: "no city",
        zipcode = this.zipcode ?: "no zipcode",
        geo = this.geo.toDomainGeo()

    )
}