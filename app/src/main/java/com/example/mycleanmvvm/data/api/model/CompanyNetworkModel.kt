package com.example.mycleanmvvm.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CompanyNetworkModel(
    @SerializedName("name")
    val name: String,
    @SerializedName("catchPhrase")
    val catchPhrase: String,
    @SerializedName("bs")
    val bs: String

)