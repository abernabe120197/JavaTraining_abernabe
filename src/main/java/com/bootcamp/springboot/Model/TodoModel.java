package com.bootcamp.springboot.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Todo")
public class TodoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
;

    public TodoModel(){}

    public TodoModel(long id, String name, String description, Date creationDate, Date schedule) {
        this.id = id;
        this.name = name;
        this.description = description;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
