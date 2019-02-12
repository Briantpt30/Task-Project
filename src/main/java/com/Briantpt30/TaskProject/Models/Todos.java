package com.Briantpt30.TaskProject.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Todos {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    public Todos() {
    }
    public Todos(String title){
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public Task getTask() {
        return task;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
