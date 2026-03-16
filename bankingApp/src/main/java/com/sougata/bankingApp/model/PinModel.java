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
@AllArgsConstructor
@NoArgsConstructor
public class PinModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int userId;
    int atmPin;
    int transactionPin;

    public PinModel(int userId, int atmPin, int transactionPin) {
        this.userId = userId;
        this.atmPin = atmPin;
        this.transactionPin = transactionPin;
    }
}
