package com.Briantpt30.TaskProject.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @OneToMany
    @JoinColumn(name = "project_id")
    private List<Task> tasks = new ArrayList<>();

    @ManyToOne
    private User user;

    @ManyToOne
    private Group group;


    public Project() {
    }

    public Project(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
