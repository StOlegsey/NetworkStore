package com.hw.networkstore.service;

import com.hw.networkstore.model.Electronics;
import com.hw.networkstore.repos.ElectronicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ElectronicsService {

    @Autowired
    private ElectronicsRepository electronicsRepository;
    private PurchaseHistoryService purchaseHistoryService;

    public ElectronicsService(PurchaseHistoryService purchaseHistoryService) {
        this.purchaseHistoryService = purchaseHistoryService;
    }

    public Electronics addElectronics(Electronics electronics){
        electronics = electronicsRepository.save(electronics);

         return electronics;
    }

    public Iterable<Electronics> getAllElectronics(){
        Iterable<Electronics> electronics=  electronicsRepository.findAll();

        return electronics;
    }

    public Electronics buyElectronics(Electronics electronics){

        Electronics electronicsById = electronicsRepository.findById(electronics.getId()).orElseThrow(() -> new NoSuchElementException());

        if(electronicsById.getAmount()>=electronics.getAmount()){
            electronicsById.setAmount(electronicsById.getAmount() - electronics.getAmount());
            addElectronics(electronicsById);
            electronics.setName(electronicsById.getName());
            purchaseHistoryService.addPurchase(electronics);

            return electronicsById;
        }

         return null;
    }
}
