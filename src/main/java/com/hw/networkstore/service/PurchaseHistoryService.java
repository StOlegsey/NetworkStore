package com.hw.networkstore.service;

import com.hw.networkstore.model.Electronics;
import com.hw.networkstore.model.NetworkPlan;
import com.hw.networkstore.model.PurchaseHistory;
import com.hw.networkstore.repos.PurchaseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PurchaseHistoryService {

    @Autowired
    private PurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseHistory addElectronics(Electronics electronics){

        PurchaseHistory purchaseHistory = new PurchaseHistory(new Date(), electronics.getName(), electronics.getAmount());

        purchaseHistory = purchaseHistoryRepository.save(purchaseHistory);

        return purchaseHistory;
    }

    public PurchaseHistory addNetworkPlan(NetworkPlan networkPlan){

        PurchaseHistory purchaseHistory = new PurchaseHistory(new Date(), networkPlan.getName(), 1);

        purchaseHistory = purchaseHistoryRepository.save(purchaseHistory);

        return purchaseHistory;
    }
}
