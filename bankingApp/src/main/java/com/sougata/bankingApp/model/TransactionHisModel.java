package com.sougata.bankingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHisModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int userId;
    int accNo;
    String transactionType;
    LocalDate transactionDate;
    LocalTime transactionTime;
    int TransactionAmount;
    int availableBalance;
    String transactionStatus;

    public TransactionHisModel(int userId, int accNo, String transactionType, LocalDate transactionDate,
                               LocalTime transactionTime, int transactionAmount, int availableBalance,
                               String transactionStatus) {
        this.userId = userId;
        this.accNo = accNo;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        TransactionAmount = transactionAmount;
        this.availableBalance = availableBalance;
        this.transactionStatus = transactionStatus;
    }
}
