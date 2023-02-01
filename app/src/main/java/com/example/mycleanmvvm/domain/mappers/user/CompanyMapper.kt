package com.example.mycleanmvvm.domain.mappers.user


import com.example.mycleanmvvm.data.api.model.CompanyNetworkModel
import com.example.mycleanmvvm.domain.models.CompanyDomainModel

fun CompanyNetworkModel.toDomainCompany(): CompanyDomainModel {
    if (this == null) return CompanyDomainModel(
        name = "no name",
        catchPhrase = "",
        bs = ""

    )

    return CompanyDomainModel(
        name = this.name ?: "no name",
        catchPhrase = this.catchPhrase ?: "no catchPhrase",
        bs = this.bs ?: "no bs"
    )
}