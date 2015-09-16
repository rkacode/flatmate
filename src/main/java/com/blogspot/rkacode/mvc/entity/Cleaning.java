package com.blogspot.rkacode.mvc.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cleaning")
public class Cleaning extends AbstractEntity {

    @Temporal(TemporalType.DATE)
    private Date date;

    private boolean done;

    @ManyToOne
    private User cleanedBy;

    public Cleaning(Date date, boolean done, User cleanedBy) {
        this.date = date;
        this.done = done;
        this.cleanedBy = cleanedBy;
    }

    public Cleaning() {}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public User getCleanedBy() {
        return cleanedBy;
    }

    public void setCleanedBy(User cleanedBy) {
        this.cleanedBy = cleanedBy;
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
