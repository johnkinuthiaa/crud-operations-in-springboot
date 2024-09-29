package com.todo.todolist.service;

import com.todo.todolist.model.Todos;
import com.todo.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TodoService implements TodoServiceInterface{
    private final TodoRepository repository;

    public TodoService(TodoRepository repository){
        this.repository=repository;
    }
    @Override
    public List<Todos> getAllTodos(){
        if(repository.findAll().isEmpty()){
            throw new RuntimeException("todo list is empty");
        }
        return repository.findAll();
    }
    @Override
    public Todos createNewTodo(Todos todo,Long id){
        if(repository.findById(id).isPresent()){
            throw new RuntimeException("todo already exists");
        }
        return repository.save(todo);
    }
    @Override
    public Todos getTodoById(Long id){
        return repository.findById(id).orElse(null);
    }
    @Override
    public List<Todos> getTodoByDate(LocalDate date){
        return repository.findAll().stream()
                .filter(todos -> todos.getCreatedOn().isEqual(date))
                .toList();
    }
    @Override
    public List<Todos> getTodoByName(String name){
        return repository.findAll().stream()
                .filter(todos ->todos.getTodo().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
    @Override
    public Todos updateTodoList(Todos todo, Long id){
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("todo does not exist");
        } else if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        }
        return repository.save(todo);
    }
    @Override
    public void deleteAllTodos(){
        repository.deleteAll();
    }
    @Override
    public void deleteTodoById(Todos todo, Long id){
        if(repository.findById(id).isPresent()){
            repository.delete(todo);
        }
    }

}
