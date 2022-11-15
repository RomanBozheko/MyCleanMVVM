package com.example.mycleanmvvm.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ComapanyNetworkModel {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("catchPhrase")
    @Expose
    var catchPhrase: String? = null

    @SerializedName("bs")
    @Expose
    var bs: String? = null
}