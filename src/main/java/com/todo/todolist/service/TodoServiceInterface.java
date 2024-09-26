package com.todo.todolist.service;

import com.todo.todolist.model.Todos;

import java.util.List;

public interface TodoServiceInterface {
    List<Todos> getAllTodos();
    Todos createNewTodo(Todos todo,Long id);
    Todos getTodoById(Long id);
    Todos updateTodoList(Todos todo, Long id);
    void deleteAllTodos();
    void deleteTodoById(Todos todo, Long id);
}
