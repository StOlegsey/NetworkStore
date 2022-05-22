package com.hw.networkstore.controllers;

import com.hw.networkstore.model.Electronics;
import com.hw.networkstore.model.NetworkPlan;
import com.hw.networkstore.model.PurchaseHistory;
import com.hw.networkstore.repos.NetworkPlanRepository;
import com.hw.networkstore.service.ElectronicsService;
import com.hw.networkstore.service.NetworkPlanService;
import com.hw.networkstore.service.PurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner {

    private final NetworkPlanService networkPlanService;
    private final ElectronicsService electronicsService;
    private final PurchaseHistoryService purchaseHistoryService;

    private final Electronics electronics1 = new Electronics("Microwolnovka", 30, 300);
    private final Electronics electronics2 = new Electronics("Iphone 13", 100, 999);

    private final NetworkPlan networkPlan1 = new NetworkPlan("Тарифищеее", 200, 30, 100);
    private final NetworkPlan networkPlan2 = new NetworkPlan("Разговор", 100, 10, 400);

    private final PurchaseHistory purchaseHistory1 = new PurchaseHistory(new Date(),"Microwolnowka");
    private final PurchaseHistory purchaseHistory2 = new PurchaseHistory(new Date(),"Iphone 13");

    @Autowired
    public DataLoader(NetworkPlanService networkPlanService, ElectronicsService electronicsService, PurchaseHistoryService purchaseHistoryService){
        this.networkPlanService = networkPlanService;
        this.electronicsService = electronicsService;
        this.purchaseHistoryService = purchaseHistoryService;
    }

    public void run(ApplicationArguments args){
        electronicsService.addElectronics(electronics1);
        electronicsService.addElectronics(electronics2);

        networkPlanService.addNetworkPlan(networkPlan1);
        networkPlanService.addNetworkPlan(networkPlan2);

        purchaseHistoryService.addPurchase(purchaseHistory1);
        purchaseHistoryService.addPurchase(purchaseHistory2);
    }
}
