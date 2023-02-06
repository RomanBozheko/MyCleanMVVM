package com.example.mycleanmvvm.data.api.model

import com.google.gson.annotations.SerializedName

class TaskNetworkModel(
    @SerializedName ("userId")
    val userId: Int,
    @SerializedName ("id")
    val id: Int,
    @SerializedName ("title")
    val title: String,
    @SerializedName ("completed")
    val completed: Boolean
)