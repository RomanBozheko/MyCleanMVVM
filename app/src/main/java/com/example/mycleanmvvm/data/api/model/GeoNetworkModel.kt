package com.example.mycleanmvvm.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GeoNetworkModel {
    @SerializedName("lat")
    @Expose
    var lat: String? = null

    @SerializedName("lng")
    @Expose
    var lng: String? = null
}