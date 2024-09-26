package com.todo.todolist.repository;

import com.todo.todolist.model.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todos,Long> {
}
