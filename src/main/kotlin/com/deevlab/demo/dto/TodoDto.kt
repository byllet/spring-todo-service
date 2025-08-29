package com.deevlab.demo.dto

data class TodoNoIdDto(val title: String, val description: String? = null, val completed: Boolean)

data class TodoDto(
        val id: Long?,
        var title: String,
        var description: String?,
        var completed: Boolean
)
