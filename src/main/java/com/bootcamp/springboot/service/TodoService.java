package com.bootcamp.springboot.service;

import com.bootcamp.springboot.Model.TodoModel;
import org.springframework.stereotype.Service;
import java.util.Date;


@Service
public class TodoService {

    public TodoModel getSingleTask(String name) {
        TodoModel todo = new TodoModel();
        todo.setName(name);
        todo.setDescription("Sample harcoded description");
        Date currentDate = new Date();
        todo.setCreationDate(currentDate);
        todo.setSchedule(currentDate);
        return todo;
    }
}
