package com.bootcamp.springboot.Api;

import com.bootcamp.springboot.Model.TodoModel;
import com.bootcamp.springboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoRestController {

    TodoService todoService;

    @Autowired
    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/grid")
    public ResponseEntity getTodoList(Model model) {
        List<TodoModel> result = this.todoService.listAll();
        if (result.isEmpty()) {
            return new ResponseEntity<List<TodoModel>>(result, HttpStatus.MULTI_STATUS.NOT_FOUND);
        }
        return new ResponseEntity<List<TodoModel>>(result, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity setTodo(TodoModel model) {
        this.todoService.setTodo(model);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
