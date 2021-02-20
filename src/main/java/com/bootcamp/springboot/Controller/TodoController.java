package com.bootcamp.springboot.Controller;

import com.bootcamp.springboot.Config.DbConfig;
import com.bootcamp.springboot.Model.TodoModel;
import com.bootcamp.springboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;


@Controller
public class TodoController {

    private TodoService todoService;
    private DbConfig dbConfig;

    @Autowired
    public TodoController(TodoService todoService, DbConfig dbConfig) {
        this.dbConfig = dbConfig;
        this.todoService = todoService;
    }

    @GetMapping("/todo")
    public String Todo(Model model) {
        List<TodoModel> todo = this.todoService.listAll();
        model.addAttribute("todoList", todo);
        model.addAttribute("todo",new TodoModel());
        return "Todo";
    }

    @GetMapping("/todoGrid")
    @ResponseBody
    public List<TodoModel> list() {
        return this.todoService.listAll();
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("todo",new TodoModel());
        model.addAttribute("action","create");
        return "Todo";
    }


    @PostMapping("/add-todo")
    public String add(@ModelAttribute TodoModel todo,Model model) {
        todoService.AddNewTodo(todo);
        List<TodoModel> list = this.todoService.listAll();
        model.addAttribute("todoList", list);
        return "redirect:todo";
    }

    @PostMapping("/edit-todo")
    public String editTodo(@ModelAttribute TodoModel todo,Model model) {
        todoService.setTodo(todo);
        List<TodoModel> list = this.todoService.listAll();
        model.addAttribute("todoList", list);
        return "redirect:todo";
    }

    @GetMapping("/delete-todo")
    public String delete(@ModelAttribute TodoModel todo,Model model) {
        todoService.deleteTodo(todo);
        List<TodoModel> list = this.todoService.listAll();
        model.addAttribute("todoList", list);
        return "redirect:todo";
    }

}
