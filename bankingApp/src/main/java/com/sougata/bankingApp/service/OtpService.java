package com.sougata.bankingApp.service;

import com.sougata.bankingApp.model.OtpModel;
import com.sougata.bankingApp.reposetory.OtpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class OtpService {
    @Autowired
    private JavaMailSender mailSender;

    private final SecureRandom random = new SecureRandom();
    @Autowired
    OtpRepo repo;

    public String sendOTP(int userId,String toEmail) {
        try {
            int otp = generateOtp();

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject("Your OTP Code");
            message.setText(
                    "Dear Customer,\n\n" +
                            "Your One-Time Password (OTP) for verification is: " + otp + "\n\n" +
                            "This OTP is valid for the next 5 minutes.\n" +
                            "For your security, please do not share this code with anyone.\n\n" +
                            "If you did not request this OTP, please ignore this email or contact our support team immediately.\n\n" +
                            "Regards,\n" +
                            "Banking App Team"
            );

            mailSender.send(message);

            // Only save if mail is successfully sent
            OtpModel existingOtp = repo.findByUserId(userId);
            if(existingOtp!=null){
                existingOtp.setOtp(otp);
                repo.save(existingOtp);
            }
            else {
                repo.save(new OtpModel(userId, otp));
            }

            return "OTP_SENT";

        } catch (Exception e) {
            return "Failed to send OTP";
        }
    }

    public int generateOtp() {
        int otp;
        otp = 1000 + random.nextInt(9000);
        return otp;
    }


    public String verifyOtp(int userId, int otp) {
        System.out.println("Verifying OTP for user " + userId + " with OTP " + otp);
        OtpModel ob = repo.findByUserId(userId);
        if (ob == null) {
            return "OTP not found";
        }
        if(ob.getOtp()==otp){
            repo.deleteById(ob.getOtpId());
            return "Success";
        }
        else{
            return "Fail";
        }
    }
}
