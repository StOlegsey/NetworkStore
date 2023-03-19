package com.hw.networkstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchasehistory")
@Setter
@Getter
public class PurchaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "amount", nullable = false, length = 30)
    private int amount;
    @Column(name = "date", nullable = false, length = 30)
    private Date date;

    @Column(name = "user_id", nullable = false, length = 30)
    private int user_id;

    public PurchaseHistory(Date date, String name, int amount) {
        this.date = date;
        this.name = name;
        this.amount = amount;
    }

    public PurchaseHistory(){

    }

}
