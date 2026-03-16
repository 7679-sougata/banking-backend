package com.sougata.bankingApp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String address;
    String email;
    String password;
    String AadhaarNo;
    int accNo;
    int atmNo;

    public BankModel(String name, String address, String email,String password, String AadhaarNo, int accNo, int atmNo) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.AadhaarNo = AadhaarNo;
        this.accNo = accNo;
        this.atmNo = atmNo;
    }
}
