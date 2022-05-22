package com.hw.networkstore.controllers;
import com.hw.networkstore.model.Electronics;
import com.hw.networkstore.service.ElectronicsService;
import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    private final ElectronicsService electronicsService;

    @Autowired
    public MainController(ElectronicsService electronicsService){this.electronicsService = electronicsService;}

    @RequestMapping({"", "/"})
    public String mainPage(Model model, Electronics electronics){
        model.addAttribute("elect", "test");

        return "index";
    }

    /*@PostMapping("/add")
    public Electronics add(@RequestBody Electronics electronics) {
        return electronicsService.addElectronics(electronics);
    }*/

}
