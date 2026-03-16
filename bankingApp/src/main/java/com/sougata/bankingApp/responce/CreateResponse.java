package com.sougata.bankingApp.responce;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@RequiredArgsConstructor
public class CreateResponse {
    int accNo;
    int atmNo;
    String massage;

    public CreateResponse(int accNo, int atmNo, String massage) {
        this.accNo = accNo;
        this.atmNo = atmNo;
        this.massage = massage;
    }

//    public CreateResponse() {
//    }
}
