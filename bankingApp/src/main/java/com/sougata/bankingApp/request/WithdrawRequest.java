package com.sougata.bankingApp.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawRequest {
    int userId;
    int accNo;
    int transactionPin;
    int cash;
}
