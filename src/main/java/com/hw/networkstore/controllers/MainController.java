package com.hw.networkstore.controllers;
import com.hw.networkstore.model.*;
import com.hw.networkstore.repos.PurchaseHistoryRepository;
import com.hw.networkstore.repos.RoleRepository;
import com.hw.networkstore.repos.UserRepository;
import com.hw.networkstore.service.CustomUserDetails;
import com.hw.networkstore.service.ElectronicsService;
import com.hw.networkstore.service.NetworkPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collections;
import java.util.List;

@Controller
public class MainController {

    private final ElectronicsService electronicsService;
    private final NetworkPlanService networkPlanService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PurchaseHistoryRepository purchaseHistoryRepository;

    @Autowired
    public MainController(ElectronicsService electronicsService, NetworkPlanService networkPlanService, RoleRepository roleRepository, UserRepository userRepository, PurchaseHistoryRepository purchaseHistoryRepository){
        this.electronicsService = electronicsService;
        this.networkPlanService = networkPlanService;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    @GetMapping({"", "/"})
    public String mainPage(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model){

        System.out.println("user_id: "+customUserDetails.getId());
        model.addAttribute("elecs", electronicsService.getAllElectronics());
        model.addAttribute("plans", networkPlanService.getAllPlans());
        model.addAttribute("user", customUserDetails);
        return "index";
    }

    @PostMapping({"", "/","index"})
    public String mainPagePurchase(@AuthenticationPrincipal CustomUserDetails customUserDetails, @RequestParam(required = false, name = "eid") Integer eid, @RequestParam(required = false, name = "pid") Integer pid, @RequestParam(required = false, name = "eamount") Integer eamount){

        Integer user_id = customUserDetails.getId();

        System.out.println("eid: "+eid);
        System.out.println("pid: "+pid);
        System.out.println("user_id: "+user_id);

        if(eid != null) {
            Electronics electronics = new Electronics();
            electronics.setAmount(eamount);
            electronics.setId(eid);
            Electronics electronicsFind = electronicsService.buyElectronics(electronics, user_id);

           if(electronicsFind==null){
                return "redirect:/error";
            }
        }

        if(pid != null){
            NetworkPlan networkPlan = new NetworkPlan();
            networkPlan.setId(pid);
            networkPlanService.buyNetworkPlan(networkPlan, user_id);
        }
        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @GetMapping("/lk")
    public String listOfUser(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model) {

        int user_id = customUserDetails.getId();

        System.out.println("user_idGET: "+user_id);
        List<PurchaseHistory> purchaseHistories = purchaseHistoryRepository.ListByUserId(user_id);
        model.addAttribute("listOfUser", purchaseHistories);

        return "lk";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role roles = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);

        return "register_success";
    }

}
