/*package com.hw.networkstore.controllers;

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

    private final Electronics electronics1 = new Electronics("Микроволновка Tide", 30, 300);
    private final Electronics electronics2 = new Electronics("Iphone 13 Pro 256 Gb/8Gb 64Mp Bright-Blue", 100, 999);
    private final Electronics electronics3 = new Electronics("Холодильник Intel Xeon", 20, 870);
    private final Electronics electronics4 = new Electronics("GPU Nvidia GeForce Rx 6700xt", 5, 1999);
    private final Electronics electronics5 = new Electronics("Кофеварка Philips", 15, 790);
    private final Electronics electronics6 = new Electronics("Флеш накопитель серый, 128Гб", 185, 5);

    private final NetworkPlan networkPlan1 = new NetworkPlan("Тарифищеее", 200, 30, 100);
    private final NetworkPlan networkPlan2 = new NetworkPlan("Разговор", 100, 10, 400);
    private final NetworkPlan networkPlan3 = new NetworkPlan("Разговор+", 150, 10, 800);
    private final NetworkPlan networkPlan4 = new NetworkPlan("ДоСвязи", 50, 3, 200);

    @Autowired
    public DataLoader(NetworkPlanService networkPlanService, ElectronicsService electronicsService, PurchaseHistoryService purchaseHistoryService){
        this.networkPlanService = networkPlanService;
        this.electronicsService = electronicsService;
        this.purchaseHistoryService = purchaseHistoryService;
    }

    public void run(ApplicationArguments args){
        electronicsService.addElectronics(electronics1);
        electronicsService.addElectronics(electronics2);
        electronicsService.addElectronics(electronics3);
        electronicsService.addElectronics(electronics4);
        electronicsService.addElectronics(electronics5);
        electronicsService.addElectronics(electronics6);

        networkPlanService.addNetworkPlan(networkPlan1);
        networkPlanService.addNetworkPlan(networkPlan2);
        networkPlanService.addNetworkPlan(networkPlan3);
        networkPlanService.addNetworkPlan(networkPlan4);

    }
}*/
