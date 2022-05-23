package com.hw.networkstore.controllers;
import com.hw.networkstore.model.Electronics;
import com.hw.networkstore.service.ElectronicsService;
import com.hw.networkstore.service.NetworkPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String mainPagePurchase(@RequestParam Long eid, @RequestParam String eamount, Model model){
        if( eid!= null) {
            Electronics electronics = new Electronics();
            electronics.setId(eid);
            electronics.setName(eamount);
            electronicsService.addElectronics(electronics);
        }
        return "index";
    }

}
