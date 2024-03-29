package com.example.mycleanmvvm.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AddressNetworkModel(
    @SerializedName("street")
    val street: String,
    @SerializedName("suite")
    val suite: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("zipcode")
    val zipcode: String,
    @SerializedName("geo")
    val geo: GeoNetworkModel?
    )
