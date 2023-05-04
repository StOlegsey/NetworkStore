package com.hw.networkstore.service;

import com.hw.networkstore.model.BaseEntity;
import com.hw.networkstore.model.Electronics;
import com.hw.networkstore.model.NetworkPlan;
import com.hw.networkstore.model.PurchaseHistory;
import com.hw.networkstore.repos.PurchaseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PurchaseHistoryService {

    @Autowired
    private PurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseHistory addPurchase(BaseEntity baseEntity, Integer user_id){

        int amount = 1;

        if(baseEntity.getClass().getName()=="com.hw.networkstore.model.Electronics"){

            Electronics electronics = (Electronics) baseEntity;
            amount=electronics.getAmount();
        }

        PurchaseHistory purchaseHistory = new PurchaseHistory(new Date(), baseEntity.getName(), amount, user_id);

        purchaseHistory = purchaseHistoryRepository.save(purchaseHistory);

        return purchaseHistory;
    }

    public void buyFromCart(Integer id){

        purchaseHistoryRepository.deleteById(id);

    }
}
