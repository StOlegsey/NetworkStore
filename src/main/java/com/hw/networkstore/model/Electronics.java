package com.hw.networkstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Electronics {

    @Id
    @GeneratedValue()
    private Long id;

    private String name;
    private int amount;
    private int price;

    public Electronics(String name, int amount, int price) {
        super();
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Electronics(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
