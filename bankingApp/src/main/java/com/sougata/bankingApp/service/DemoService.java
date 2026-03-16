package com.sougata.bankingApp.service;


import com.sougata.bankingApp.model.DemoModel;
import com.sougata.bankingApp.reposetory.DemoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

//    @Autowired
    DemoRepo demoRepo;

    public DemoService(DemoRepo demoRepo)
    {
        this.demoRepo = demoRepo;
    }

    public List<DemoModel> test()
    {
        return demoRepo.findAll();
    }

}
