package com.example.mycleanmvvm.domain.models

data class UserDomainModel(
    var id: Int,
    var name: String,
    var username: String,
    var email: String,
    var address: AddressDomainModel,
    var phone: String,
    var website: String,
    var company: CompanyDomainModel?
)
