package com.sougata.bankingApp.service;

import com.sougata.bankingApp.model.PinModel;
import com.sougata.bankingApp.reposetory.PinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PinService {
    @Autowired
    PinRepo repo;

    public String savePin(PinModel pinModel) {
        repo.save(pinModel);
        return "success";
    }

    public boolean isSetPin(int userId) {
        PinModel model = repo.findByUserId(userId);
        if(model != null) {
            return true;
        }
        return false;
    }

    public String changeAtmPin(int userId, int atmPin) {
        PinModel model = repo.findByUserId(userId);
        model.setAtmPin(atmPin);
        repo.save(model);
        return "success";
    }

    public String changeTransPin(int userId, int transPin) {
        PinModel model = repo.findByUserId(userId);
        model.setTransactionPin(transPin);
        repo.save(model);
        return "success";
    }
}
