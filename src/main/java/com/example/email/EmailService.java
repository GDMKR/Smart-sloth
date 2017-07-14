package com.example.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


/**
 * Created by fifa13 on 14.07.2017.
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("yurii.haidamaka@gmail.com");
        mailMessage.setSubject("topic");
        mailMessage.setText("Hi!");
        mailMessage.setFrom("ga1damakay@gmail.com");
        javaMailSender.send(mailMessage);
    }
}
