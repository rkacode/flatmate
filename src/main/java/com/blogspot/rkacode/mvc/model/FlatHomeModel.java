package com.blogspot.rkacode.mvc.model;

import com.blogspot.rkacode.mvc.entity.User;

import java.util.Set;

public class FlatHomeModel {

    private boolean owner;

    private Set<User> users;

    private String name;

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
