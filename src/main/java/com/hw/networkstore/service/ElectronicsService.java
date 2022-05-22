package com.hw.networkstore.service;

import com.hw.networkstore.model.Electronics;
import com.hw.networkstore.repos.ElectronicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectronicsService {

    @Autowired
    private ElectronicsRepository electronicsRepository;

    public Electronics addElectronics(Electronics electronics){
        electronics = electronicsRepository.save(electronics);

         return electronics;
    }
}
