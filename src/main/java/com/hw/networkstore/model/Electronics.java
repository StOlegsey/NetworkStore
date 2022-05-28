package com.hw.networkstore.model;

import javax.persistence.*;

@Entity
public class Electronics extends BaseEntity{

    private int amount;

    public Electronics(String name, int amount, int price) {
        super();
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Electronics(){

    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
