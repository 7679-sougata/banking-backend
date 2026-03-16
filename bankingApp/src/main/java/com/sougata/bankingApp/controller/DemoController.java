package com.sougata.bankingApp.controller;


import com.sougata.bankingApp.model.DemoModel;
import com.sougata.bankingApp.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    DemoService service;

    @GetMapping("/hello")
    String sayHello() {
        return "Hello World";
    }

    @GetMapping("/test")
    List<DemoModel> test()
    {
        return service.test();
    }
}