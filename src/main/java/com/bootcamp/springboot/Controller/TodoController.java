package com.bootcamp.springboot.Controller;

import com.bootcamp.springboot.Config.DbConfig;
import com.bootcamp.springboot.Model.TodoModel;
import com.bootcamp.springboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class TodoController {

    private TodoService todoService;
    private DbConfig dbConfig;

    @Autowired
    public TodoController(TodoService todoService, DbConfig dbConfig) {
        this.dbConfig = dbConfig;
        this.todoService = todoService;
    }
    @GetMapping("/todo")
    TodoModel getSingleTask() {

        TodoModel model = new TodoModel();
        model = this.todoService.getSingleTask("Task");
        System.out.println("TaskName: " + model.getName());
        return model;
    }

}
