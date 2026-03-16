package com.sougata.bankingApp.service;

import com.sougata.bankingApp.model.CashModel;
import com.sougata.bankingApp.model.PinModel;
import com.sougata.bankingApp.model.TransactionHisModel;
import com.sougata.bankingApp.reposetory.CashRepo;
import com.sougata.bankingApp.reposetory.PinRepo;
import com.sougata.bankingApp.reposetory.TransactionHisRepo;
import com.sougata.bankingApp.request.CheekBalRequest;
import com.sougata.bankingApp.request.WithdrawRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class CashService {
    @Autowired
    CashRepo cashRepo;
    @Autowired
    PinRepo pinRepo;
    @Autowired
    TransactionHisRepo  transactionHisRepo;

    public String deposit(CashModel cashModel){
        try
        {
            CashModel cashModel1 = cashRepo.findByAccNo(cashModel.getAccNo());
            cashModel1.setBalance(cashModel.getBalance()+cashModel1.getBalance());
            cashRepo.save(cashModel1);
            TransactionHisModel transactionHisModel =
                    new TransactionHisModel(cashModel.getUserId(), cashModel.getAccNo(),"DEPOSIT",
                            LocalDate.now(), LocalTime.now(),cashModel.getBalance(),
                            cashRepo.findByAccNo(cashModel.getAccNo()).getBalance(),"SUCCESS");
            transactionHisRepo.save(transactionHisModel);
            return "success";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }

    public String withdraw(WithdrawRequest request){
        try
        {
            CashModel model = cashRepo.findByAccNo(request.getAccNo());
            PinModel pinModel = pinRepo.findByUserId(request.getUserId());

            if( pinModel.getTransactionPin()==request.getTransactionPin())
            {
                if(model.getBalance() >= request.getCash()){
                    model.setBalance(model.getBalance() - request.getCash());
                    cashRepo.save(model);
                    TransactionHisModel transactionHisModel =
                            new TransactionHisModel(request.getUserId(), request.getAccNo(), "WITHDRAW"
                                    ,LocalDate.now(),LocalTime.now(),request.getCash(),model.getBalance()
                                    ,"SUCCESS");
                    transactionHisRepo.save(transactionHisModel);
                    return "success";
                }
                else {
                    return "insufficient_balance";
                }
            }
            else {
                return "Wrong_pin";
            }
        }
        catch(Exception ex)
        {
            return ex.getMessage();
        }
    }

    public int cheekBalance(CheekBalRequest request){

        try
        {
            PinModel pinModel = pinRepo.findByUserId(request.getUserId());

            if(pinModel.getTransactionPin()==request.getTransactionPin())
            {
                return cashRepo.findByAccNo(request.getAccNo()).getBalance();
            }
            else {
                return -1;
            }
        }
        catch (Exception ex)
        {
            return -1;
        }
    }


    public List<TransactionHisModel> getHisByAccNo(int accNo){
        return transactionHisRepo.findAllByAccNo(accNo);
    }


}
