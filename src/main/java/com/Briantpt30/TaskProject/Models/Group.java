package com.Briantpt30.TaskProject.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Group {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(max=30)
    private String name;


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
