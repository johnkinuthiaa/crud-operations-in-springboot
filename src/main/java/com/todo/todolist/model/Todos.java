package com.todo.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Todos {
    @Id
    private Long id;
    private String todo;
    private LocalDate createdOn;

    public Todos(){}
    public Todos(Long id,String todo,LocalDate createdOn){
        this.id=id;
        this.todo=todo;
        this.createdOn=createdOn;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Long getId(){
        return id;
    }
    public void setTodo(String todo){
        this.todo=todo;
    }
    public String getTodo(){
        return todo;
    }
    public void setCreatedOn(LocalDate createdOn){
        this.createdOn=createdOn;
    }
    public LocalDate getCreatedOn(){
        return createdOn;
    }
}
