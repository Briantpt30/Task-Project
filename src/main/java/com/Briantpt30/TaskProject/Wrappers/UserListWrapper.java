package com.Briantpt30.TaskProject.Wrappers;

import com.Briantpt30.TaskProject.Models.User;

import java.util.List;

public class UserListWrapper {
    private List<User> users;

    public UserListWrapper() {
    }

    public UserListWrapper(List<User> users) {
        this.users = users;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
