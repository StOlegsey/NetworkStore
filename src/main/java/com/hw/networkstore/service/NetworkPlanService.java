package com.hw.networkstore.service;

import com.hw.networkstore.model.NetworkPlan;
import com.hw.networkstore.repos.NetworkPlanRepository;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetworkPlanService {

    @Autowired
    private NetworkPlanRepository networkPlanRepository;

    public NetworkPlan addNetworkPlan(NetworkPlan networkPlan){

        networkPlan = networkPlanRepository.save(networkPlan);

        return networkPlan;
    }
}
