package com.example.mycleanmvvm.domain.mappers

import com.example.mycleanmvvm.data.api.model.ComapanyNetworkModel
import com.example.mycleanmvvm.domain.models.CompanyDomainModel

fun ComapanyNetworkModel.toDomainModel(): CompanyDomainModel {
    return CompanyDomainModel(
        name = this.name ?: "",
        catchPhrase = this.catchPhrase ?: "",
        bs = this.bs ?: ""
    )
}