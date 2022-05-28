package com.hw.networkstore.model;

import javax.persistence.Entity;

@Entity
public class NetworkPlan extends BaseEntity{

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
