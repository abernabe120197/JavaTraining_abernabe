package com.bootcamp.springboot.service;

import com.bootcamp.springboot.Model.TodoModel;
import com.bootcamp.springboot.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<TodoModel> listAll(){
        return repository.findAll();
    }

    public Optional<TodoModel> getTodoById(TodoModel todo) {
        return repository.findById(todo.getId());
    }

    public void setTodo(TodoModel todo) {
        repository.save(todo);
    }

    public void deleteTodo(TodoModel todo) {
        repository.delete(todo);
    }


    public void AddNewTodo(TodoModel todo) {
        repository.save(todo);
    }


}
