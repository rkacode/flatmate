package com.blogspot.rkacode.mvc.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "application_user")
public class User extends AbstractEntity {

    private String email;

    private String nickname;

    private String password;

    @ManyToOne
    private Flat flat;

    @OneToMany(mappedBy = "cleanedBy", cascade = CascadeType.ALL)
    private Set<Cleaning> cleanings = new HashSet<>();

    @OneToMany(mappedBy = "paidBy", cascade = CascadeType.ALL)
    private Set<Expense> expenses = new HashSet<>();

    public User(String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public User() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Cleaning> getCleanings() {
        return cleanings;
    }

    public void setCleanings(Set<Cleaning> cleanings) {
        this.cleanings = cleanings;
    }

    public Set<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<Expense> expenses) {
        this.expenses = expenses;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return !(id != null ? !id.equals(user.id) : user.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
