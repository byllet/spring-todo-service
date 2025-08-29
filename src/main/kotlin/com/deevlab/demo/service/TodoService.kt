package com.deevlab.demo.service

import com.deevlab.demo.dto.TodoDto
import com.deevlab.demo.dto.TodoNoIdDto
import com.deevlab.demo.mapper.TodoMapper
import com.deevlab.demo.repository.TodoRepository
import java.util.*
import org.springframework.stereotype.Service

@Service
class TodoService(private val repository: TodoRepository) {

    fun create(dto: TodoNoIdDto): TodoDto {
        val entity = TodoMapper.toEntity(dto)
        val savedEntity = repository.save(entity)
        return TodoMapper.toDto(savedEntity)
    }

    fun getAll(): List<TodoDto> = repository.findAll().map { TodoMapper.toDto(it) }

    fun getById(id: Long): Optional<TodoDto> = repository.findById(id).map { TodoMapper.toDto(it) }

    fun update(id: Long, dto: TodoNoIdDto): Optional<TodoDto> {
        return repository.findById(id).map { existingTodo ->
            TodoMapper.updateEntityFromDto(existingTodo, dto)
            val updatedTodo = repository.save(existingTodo)
            TodoMapper.toDto(updatedTodo)
        }
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }
}
