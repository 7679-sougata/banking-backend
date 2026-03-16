package com.sougata.bankingApp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CashModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int userId;
    int accNo;
    int balance;

    public CashModel(int userId, int accNo, int balance) {
        this.userId = userId;
        this.accNo = accNo;
        this.balance = balance;
    }
}
