package br.com.escuderodev.parking.controllers;

import br.com.escuderodev.parking.models.notification.SMSRequest;
import br.com.escuderodev.parking.services.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SMSController {

    private final TwilioService twilioService;

    @Autowired
    public SMSController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @PostMapping("/send-sms")
    public void sendSMS(@RequestBody SMSRequest request) {
        twilioService.sendSMS(request.getTo(), request.getMessage());
    }
}