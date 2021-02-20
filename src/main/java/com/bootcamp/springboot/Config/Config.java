package com.bootcamp.springboot.Config;

import com.bootcamp.springboot.Controller.TodoController;
import com.bootcamp.springboot.Repository.TodoRepository;
import com.bootcamp.springboot.service.TodoService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Config {

    @Bean
    public TodoService getTodoService() {
        return new TodoService();
    }

}
