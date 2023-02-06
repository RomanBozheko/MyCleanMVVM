package com.example.mycleanmvvm.domain.mappers.task

import com.example.mycleanmvvm.data.api.model.TaskNetworkModel
import com.example.mycleanmvvm.domain.models.TaskDomainModel


fun TaskNetworkModel.toDomainTask(): TaskDomainModel {
    return TaskDomainModel(
        userId = this.userId,
        id = this.id,
        title = this.title,
        completed = this.completed
    )
}

