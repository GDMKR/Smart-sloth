package com.example.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fifa13 on 14.07.2017.
 */
@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("email")
    public void sendMail() {
        emailService.sendMail();
    }
}
