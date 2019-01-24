package com.Briantpt30.TaskProject.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(max = 40)
    private String title;

    @NotNull
    private String description;


    public Task() {
    }

    public Task(String title, String description){
        this.title = title;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
