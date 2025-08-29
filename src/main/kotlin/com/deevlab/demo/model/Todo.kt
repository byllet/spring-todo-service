package com.deevlab.demo.model

import jakarta.persistence.*

@Entity
class Todo(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
        var title: String = "",
        var description: String? = null,
        var completed: Boolean = false
)
