package com.example.mycleanmvvm.domain.mappers

import com.example.mycleanmvvm.data.api.model.GeoNetworkModel
import com.example.mycleanmvvm.domain.models.GeoDomainModel

fun GeoNetworkModel.toDomain(): GeoDomainModel{
    return GeoDomainModel(
        lat = this.lat ?: "",
        lng = this.lng ?: ""
    )
}