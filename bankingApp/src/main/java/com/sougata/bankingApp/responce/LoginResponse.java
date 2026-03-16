package com.sougata.bankingApp.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    int userId;
    String userName;
    int  accNo;
    String email;
    String message;
}
