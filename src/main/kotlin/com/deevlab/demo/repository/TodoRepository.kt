package com.deevlab.demo.repository

import com.deevlab.demo.model.Todo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository interface TodoRepository : CrudRepository<Todo, Long>
