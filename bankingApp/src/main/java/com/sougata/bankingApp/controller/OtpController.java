package com.sougata.bankingApp.controller;

import com.sougata.bankingApp.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/otp")
@CrossOrigin("*")
public class OtpController {

    @Autowired
    OtpService otpService;

    @GetMapping("/sendotp")
    public ResponseEntity<String> sendOtp(@RequestParam int userId,@RequestParam String email) {
        return ResponseEntity.status(HttpStatus.OK).body(otpService.sendOTP(userId,email));
    }


    @GetMapping("/verifyotp")
    public ResponseEntity<String> verifyOtp(@RequestParam int userId,@RequestParam int otp) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(otpService.verifyOtp(userId,otp));
    }

    

}
