package com.blogspot.rkacode.mvc.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "expense")
public class Expense extends AbstractEntity {

    private BigDecimal value;

    @ManyToOne
    private User paidBy;

    @Temporal(TemporalType.DATE)
    private Date date;

    public Expense(BigDecimal value, User paidBy, Date date) {
        this.value = value;
        this.paidBy = paidBy;
        this.date = date;
    }

    public Expense() {}

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
