package com.sougata.bankingApp.controller;


import com.sougata.bankingApp.model.CashModel;
import com.sougata.bankingApp.model.TransactionHisModel;
import com.sougata.bankingApp.request.CheekBalRequest;
import com.sougata.bankingApp.request.WithdrawRequest;
import com.sougata.bankingApp.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cash")
@CrossOrigin(origins = "*")
public class CashController {
    @Autowired
    CashService cashService;

    @PostMapping("/deposit")
    public String deposit(@RequestBody CashModel cashModel) {
        return cashService.deposit(cashModel);
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestBody WithdrawRequest request) {
        return cashService.withdraw(request);
    }

    @PostMapping("/cheekbalance")
    public int cheekBalance(@RequestBody CheekBalRequest request) {
        return cashService.cheekBalance(request);
    }

    @PostMapping("/gethistory")
    public List<TransactionHisModel> getHistory(@RequestParam int accNo)
    {
        return cashService.getHisByAccNo(accNo);
    }
}
