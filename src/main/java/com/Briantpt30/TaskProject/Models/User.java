package com.Briantpt30.TaskProject.Models;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String fname;

    @NotNull
    private String lname;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Project> projects = new ArrayList<>();

    @ManyToMany(mappedBy = "users")
    private List<Group> groups;

    public User() {
    }
    public User(String fname, String lname, String email, String password){

    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
