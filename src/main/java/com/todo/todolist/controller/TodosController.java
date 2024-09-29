package com.todo.todolist.controller;

import com.todo.todolist.model.Todos;
import com.todo.todolist.service.TodoServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/v1/to-do")
public class TodosController{
    private final TodoServiceInterface service;
    public TodosController(TodoServiceInterface service){
        this.service=service;
    }

    @GetMapping("/all")
    public List<Todos> getAllTodos(){
        return service.getAllTodos();
    }
    @GetMapping("/get-todo-by-id")
    public Todos getTodoById(@RequestParam Long id){
        return service.getTodoById(id);
    }
    @GetMapping("/get/name")
    public ResponseEntity<List<Todos>> getTodoByName(@RequestParam String name){
        return new ResponseEntity<>(service.getTodoByName(name), HttpStatus.OK);
    }
    @GetMapping("/get/by-date")
    public ResponseEntity<List<Todos>> getTodoByDate(@RequestParam LocalDate date){
        return new ResponseEntity<>(service.getTodoByDate(date),HttpStatus.OK);
    }
    @PostMapping("/create-new-todo")
    public Todos createNewTodo(@RequestBody Todos todo,@RequestParam Long id){
        return service.createNewTodo(todo,id);
    }
    @PutMapping("/update-todo")
    public Todos updateTodoList(@RequestBody Todos todo,@RequestParam Long id){
        return service.updateTodoList(todo,id);
    }
    @DeleteMapping("/delete/all")
    public void deleteAllTodos(){
        service.deleteAllTodos();
    }
    @DeleteMapping("/delete-todo-by-id")
    public void deleteTodoById(Todos todo, @RequestParam Long id){
        service.deleteTodoById(todo,id);
    }

}
