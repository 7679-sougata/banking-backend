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
public class OtpModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int otpId;
    int userId;
    int otp;

    public OtpModel(int userId, int otp) {
        this.userId = userId;
        this.otp = otp;
    }
}
