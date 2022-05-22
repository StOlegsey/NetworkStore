package com.hw.networkstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NetworkPlan {

    @Id
    @GeneratedValue()
    private Long id;

    private String name;

    private int price;

    private int gbs;

    private int mins;

    public NetworkPlan(String name, int price, int gbs, int mins) {
        this.name = name;
        this.price = price;
        this.gbs = gbs;
        this.mins = mins;
    }

    public NetworkPlan(){

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGbs() {
        return gbs;
    }

    public void setGbs(int gbs) {
        this.gbs = gbs;
    }

    public int getMins() {
        return mins;
    }

    public void setMins(int mins) {
        this.mins = mins;
    }
}
