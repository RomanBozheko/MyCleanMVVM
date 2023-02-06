package com.example.mycleanmvvm.domain.models

data class TaskDomainModel(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)
