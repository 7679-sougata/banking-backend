package com.sougata.bankingApp.controller;

import com.sougata.bankingApp.model.PinModel;
import com.sougata.bankingApp.service.PinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pin")
@CrossOrigin(origins = "*")
public class PinController {

    @Autowired
    PinService pinService;

    @PostMapping("/savepin")
    public String savePin(@RequestBody PinModel pinModel) {
        return pinService.savePin(pinModel);
    }

    @GetMapping("/issetpin")
    public boolean isSetPin(@RequestParam int userId)
    {
        return pinService.isSetPin(userId);
    }

    @PostMapping("/changeatmpin")
    public String changeAtmPin(@RequestParam int userId , @RequestParam int atmPin)
    {
        return pinService.changeAtmPin(userId,atmPin);
    }

    @PostMapping("/changetranspin")
    public String changeTransPin(@RequestParam int userId , @RequestParam int transPin)
    {
        return pinService.changeTransPin(userId,transPin);
    }
}
