package com.sougata.bankingApp.controller;


import com.sougata.bankingApp.model.BankModel;
import com.sougata.bankingApp.request.AccCreateRequest;
import com.sougata.bankingApp.request.LoginRequest;
import com.sougata.bankingApp.responce.CreateResponse;
import com.sougata.bankingApp.responce.LoginResponse;
import com.sougata.bankingApp.service.BankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
public class BankController {

    BankService bankService;
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/show")
    public List<BankModel> show()
    {
        return bankService.show();
    }


    @PostMapping("/create")
    public ResponseEntity<CreateResponse> create(@RequestBody AccCreateRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(bankService.createAccount(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(bankService.login(request));

    }

//    @GetMapping("/sendotp")
//    public ResponseEntity<String> sendotp(@RequestParam String email) {
//        return ResponseEntity.status(HttpStatus.OK).body(bankService.sendOTP(email));
//    }
}
