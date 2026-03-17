package com.sougata.bankingApp.service;

import com.sougata.bankingApp.model.OtpModel;
import com.sougata.bankingApp.reposetory.OtpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
        import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Service
public class OtpService {

    @Value("${BREVO_API_KEY}")
    private String API_KEY;

    private final SecureRandom random = new SecureRandom();

    @Autowired
    OtpRepo repo;

    public String sendOTP(int userId, String toEmail) {
        try {
            int otp = generateOtp();

            String url = "https://api.brevo.com/v3/smtp/email";

            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.set("api-key", API_KEY);
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, Object> body = new HashMap<>();

            // receiver
            body.put("to", new Object[]{
                    Map.of("email", toEmail)
            });

            // sender (IMPORTANT: must be verified in Brevo)
            body.put("sender", Map.of("email", "fullstack7679@gmail.com"));

            body.put("subject", "Your OTP Code");

            body.put("htmlContent",
                    "<div style='font-family: Arial, sans-serif; max-width: 500px; margin: auto; padding: 20px; border: 1px solid #ddd; border-radius: 10px;'>"
                            + "<h2 style='color: #2c3e50; text-align: center;'>Secure OTP Verification</h2>"

                            + "<p>Dear Customer,</p>"

                            + "<p>We received a request to verify your identity. Please use the One-Time Password (OTP) below to proceed:</p>"

                            + "<div style='text-align: center; margin: 20px 0;'>"
                            + "<span style='font-size: 28px; font-weight: bold; letter-spacing: 4px; color: #27ae60;'>"
                            + otp
                            + "</span>"
                            + "</div>"

                            + "<p>This OTP is valid for <b>5 minutes</b>. For your security, please do not share this code with anyone.</p>"

                            + "<p>If you did not request this verification, please ignore this email or contact our support team immediately.</p>"

                            + "<br>"

                            + "<p>Regards,<br><b>Banking App Team</b></p>"

                            + "<hr style='margin-top: 20px;'>"
                            + "<p style='font-size: 12px; color: gray; text-align: center;'>"
                            + "This is an automated message. Please do not reply to this email."
                            + "</p>"

                            + "</div>"
            );

            HttpEntity<Map<String, Object>> request =
                    new HttpEntity<>(body, headers);

            restTemplate.postForEntity(url, request, String.class);

            // Save OTP in DB
            OtpModel existingOtp = repo.findByUserId(userId);
            if (existingOtp != null) {
                existingOtp.setOtp(otp);
                repo.save(existingOtp);
            } else {
                repo.save(new OtpModel(userId, otp));
            }

            return "OTP_SENT";

        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send OTP";
        }
    }

    public int generateOtp() {
        return 1000 + random.nextInt(9000);
    }

    public String verifyOtp(int userId, int otp) {
        OtpModel ob = repo.findByUserId(userId);

        if (ob == null) {
            return "OTP not found";
        }

        if (ob.getOtp() == otp) {
            repo.deleteById(ob.getOtpId());
            return "Success";
        } else {
            return "Fail";
        }
    }
}