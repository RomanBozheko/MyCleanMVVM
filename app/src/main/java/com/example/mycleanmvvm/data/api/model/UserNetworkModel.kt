package com.example.mycleanmvvm.data.api.model



import com.google.gson.annotations.SerializedName


class UserNetworkModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String?,
    @SerializedName("address")
    val address: AddressNetworkModel?,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("website")
    val website: String?,
    @SerializedName("company")
    val company: ComapanyNetworkModel?,
)