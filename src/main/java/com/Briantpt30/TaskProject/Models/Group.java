package com.Briantpt30.TaskProject.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Group {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(max=30)
    private String name;

    @OneToMany
    @JoinColumn(name = "group_id")
    private List<Project> projects = new ArrayList<>();

    @ManyToMany
    private List<User> users;




    public Group() {
    }

    public Group(String name){
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
