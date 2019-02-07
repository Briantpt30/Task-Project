package com.Briantpt30.TaskProject.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Comments {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3)
    private String comment;

    @ManyToOne
    private Task task;

    public Comments() {
    }
    public Comments(String comment){
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
