package com.todo.todolist.service;

import com.todo.todolist.model.Todos;

import java.time.LocalDate;
import java.util.List;

public interface TodoServiceInterface {
    List<Todos> getAllTodos();
    List<Todos> getTodoByName(String name);
    List<Todos> getTodoByDate(LocalDate date);
    Todos createNewTodo(Todos todo,Long id);
    Todos getTodoById(Long id);
    Todos updateTodoList(Todos todo, Long id);
    void deleteAllTodos();
    void deleteTodoById(Todos todo, Long id);
}
