package com.hw.networkstore.service;

import com.hw.networkstore.model.PurchaseHistory;
import com.hw.networkstore.repos.PurchaseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PurchaseHistoryService {

    @Autowired
    private PurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseHistory addPurchase(PurchaseHistory purchaseHistory){
        purchaseHistory = purchaseHistoryRepository.save(purchaseHistory);

        return purchaseHistory;
    }
}
