package com.hw.networkstore.controllers;
import com.hw.networkstore.model.Electronics;
import com.hw.networkstore.model.NetworkPlan;
import com.hw.networkstore.service.ElectronicsService;
import com.hw.networkstore.service.NetworkPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;

@Controller
public class MainController {

    private final ElectronicsService electronicsService;
    private final NetworkPlanService networkPlanService;

    @Autowired
    public MainController(ElectronicsService electronicsService, NetworkPlanService networkPlanService){
        this.electronicsService = electronicsService;
        this.networkPlanService = networkPlanService;
    }

    @GetMapping({"", "/"})
    public String mainPage(Model model){
        model.addAttribute("elecs", electronicsService.getAllElectronics());
        model.addAttribute("plans", networkPlanService.getAllPlans());
        return "index";
    }

    @PostMapping({"", "/","index"})
    public String mainPagePurchase(@RequestParam(required = false, name = "eid") Integer eid, @RequestParam(required = false, name = "pid") Integer pid, @RequestParam(required = false, name = "eamount") Integer eamount, Model model){

        System.out.println("eid "+eid);
        System.out.println("pid"+pid);
        if(eid != null) {
            Electronics electronics = new Electronics();
            electronics.setAmount(eamount);
            electronics.setId(eid);
            Electronics electronicsFind = electronicsService.buyElectronics(electronics);

            if(electronicsFind==null){
                return "redirect:/error";
            }
        }

        if(pid != null){
            NetworkPlan networkPlan = new NetworkPlan();
            networkPlan.setId(pid);
            networkPlanService.buyNetworkPlan(networkPlan);
        }
        return "redirect:/";
    }

}
