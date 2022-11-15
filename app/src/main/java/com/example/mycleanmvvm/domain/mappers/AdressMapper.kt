package com.example.mycleanmvvm.domain.mappers

import com.example.mycleanmvvm.data.api.model.AddressNetworkModel
import com.example.mycleanmvvm.domain.models.AddressDomainModel


fun AddressNetworkModel.toDomainModel(): AddressDomainModel {
    return AddressDomainModel(
        street = this.street ?: "",
        suite = this.suite ?: "",
        city = this.city ?: "",
        zipcode = this.zipcode ?: ""
    )
}