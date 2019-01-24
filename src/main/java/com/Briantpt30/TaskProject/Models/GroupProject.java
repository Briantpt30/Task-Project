package com.Briantpt30.TaskProject.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class GroupProject {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;


    public GroupProject() {
    }

    public GroupProject(String name){
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
