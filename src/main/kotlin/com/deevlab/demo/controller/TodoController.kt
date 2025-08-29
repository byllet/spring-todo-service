package com.deevlab.demo.controller

import com.deevlab.demo.dto.TodoDto
import com.deevlab.demo.dto.TodoNoIdDto
import com.deevlab.demo.service.TodoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todos")
class TodoController(private val service: TodoService) {

    @PostMapping
    fun create(@RequestBody dto: TodoNoIdDto): ResponseEntity<TodoDto> =
            ResponseEntity.ok(service.create(dto))

    @GetMapping fun getAll(): ResponseEntity<List<TodoDto>> = ResponseEntity.ok(service.getAll())

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<TodoDto> =
            service.getById(id)
                    .map { ResponseEntity.ok(it) }
                    .orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: TodoNoIdDto): ResponseEntity<TodoDto> =
            service.update(id, dto)
                    .map { ResponseEntity.ok(it) }
                    .orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }
}
