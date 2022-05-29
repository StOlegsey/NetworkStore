package com.hw.networkstore.service;

import com.hw.networkstore.model.NetworkPlan;
import com.hw.networkstore.repos.NetworkPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class NetworkPlanService {

    @Autowired
    private NetworkPlanRepository networkPlanRepository;
    private PurchaseHistoryService purchaseHistoryService;

    public NetworkPlanService(PurchaseHistoryService purchaseHistoryService) {
        this.purchaseHistoryService = purchaseHistoryService;
    }

    public NetworkPlan addNetworkPlan(NetworkPlan networkPlan){

        networkPlan = networkPlanRepository.save(networkPlan);

        return networkPlan;
    }

    public Iterable<NetworkPlan> getAllPlans(){
        Iterable<NetworkPlan> networkPlans= networkPlanRepository.findAll();

        return networkPlans;
    }

    public NetworkPlan buyNetworkPlan(NetworkPlan networkPlan){

        NetworkPlan networkPlanById = networkPlanRepository.findById(networkPlan.getId()).orElseThrow(() -> new NoSuchElementException());

        networkPlan.setName(networkPlanById.getName());
        purchaseHistoryService.addPurchase(networkPlan);

        return networkPlan;
    }
}
