package com.example.mycleanmvvm.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GeoNetworkModel(
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lng")
    val lng: String
)