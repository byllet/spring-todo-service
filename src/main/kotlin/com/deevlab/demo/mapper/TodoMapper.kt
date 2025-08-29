package com.deevlab.demo.mapper

import com.deevlab.demo.dto.TodoDto
import com.deevlab.demo.dto.TodoNoIdDto
import com.deevlab.demo.model.Todo

object TodoMapper {

    fun toEntity(dto: TodoDto): Todo =
            Todo(
                    id = dto.id,
                    title = dto.title,
                    description = dto.description,
                    completed = dto.completed
            )

    fun toEntity(dto: TodoNoIdDto): Todo =
            Todo(
                    id = null,
                    title = dto.title,
                    description = dto.description,
                    completed = dto.completed
            )

    fun toDto(entity: Todo): TodoDto {
        return TodoDto(
                id = entity.id,
                title = entity.title,
                description = entity.description,
                completed = entity.completed
        )
    }

    fun updateEntityFromDto(entity: Todo, dto: TodoNoIdDto) {
        entity.title = dto.title
        entity.description = dto.description
        entity.completed = dto.completed
    }
}
