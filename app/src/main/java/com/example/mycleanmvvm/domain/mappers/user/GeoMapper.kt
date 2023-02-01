package com.example.mycleanmvvm.domain.mappers.user

import com.example.mycleanmvvm.data.api.model.GeoNetworkModel
import com.example.mycleanmvvm.domain.models.GeoDomainModel

fun GeoNetworkModel?.toDomainGeo(): GeoDomainModel {
    if (this == null) return GeoDomainModel(
        lat = "",
        lng = ""
    )
    return GeoDomainModel(
        lat = this.lat ?: "no lat",
        lng = this.lng ?: "no lng"
    )
}