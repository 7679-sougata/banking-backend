package com.sougata.bankingApp.service;


import com.sougata.bankingApp.model.BankModel;
import com.sougata.bankingApp.model.CashModel;
import com.sougata.bankingApp.reposetory.BankRepo;
import com.sougata.bankingApp.reposetory.CashRepo;
import com.sougata.bankingApp.request.AccCreateRequest;
import com.sougata.bankingApp.request.LoginRequest;
import com.sougata.bankingApp.responce.CreateResponse;
import com.sougata.bankingApp.responce.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BankService {
    @Autowired
    BankRepo bankRepo;
    @Autowired
    CashRepo cashRepo;
    Random rand = new Random();
    BankModel bankModel;
    public CreateResponse createAccount(AccCreateRequest request)
    {
        int accNo = rand.nextInt(9999);
        int atmNo = rand.nextInt(9999);
        bankModel = new BankModel(request.name,request.address,request.email, request.password, request.AadhaarNo,accNo,atmNo);

        bankRepo.save(bankModel);
//        return " Acc Number is : "+accNo +" And ATM Number is : "+atmNo;

        //save initial balance in cash table
        CashModel cashModel =  new CashModel(bankModel.getId(),accNo,request.balance);
        cashRepo.save(cashModel);

        return new CreateResponse(accNo,atmNo,"success");
    }

    public List<BankModel> show() {
        return bankRepo.findAll();
    }

    public LoginResponse login(LoginRequest request) {

        bankModel = bankRepo.loginUser(request.getEmail(), request.getPassword());

        try{
            System.out.println(bankModel.toString());
            return new LoginResponse(bankModel.getId(),bankModel.getName(),bankModel.getAccNo(),bankModel.getEmail(),"Success");
        }
        catch (Exception e){
            return new LoginResponse(0, null, 0,null, "Invalid Credentials");
        }
     }

}