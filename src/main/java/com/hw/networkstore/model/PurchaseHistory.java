package com.hw.networkstore.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchasehistory")
public class PurchaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private int amount;

    private String name;

    public PurchaseHistory(Date date, String name, int amount) {
        this.date = date;
        this.name = name;
        this.amount = amount;
    }

    public PurchaseHistory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {return amount;}

    public void setAmount(int amount) {this.amount = amount;}
}
