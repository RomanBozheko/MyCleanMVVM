package com.example.mycleanmvvm.domain.models

data class AddressDomainModel(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: GeoDomainModel
)