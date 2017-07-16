package com.example.email;

import com.example.user.User;
import com.example.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.logging.Logger;

@Service
public class EmailService {

    Logger logger = Logger.getLogger(EmailService.class.getName());

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserService userService;

    public void sendMail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("yurii.haidamaka@gmail.com");
        mailMessage.setSubject("topic");
        mailMessage.setText("Hi!");
        mailMessage.setFrom("ga1damakay@gmail.com");
        javaMailSender.send(mailMessage);
    }

    public void sendConfirmMail(User user) {

        //random confirm Code
        String confirmCode = UUID.randomUUID().toString().replace("-","");
        user.setConfirmCode(confirmCode);
        userService.addUser(user);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("The Confirmation");
        mailMessage.setText(confirmCode);
        mailMessage.setFrom("ga1damakay@gmail.com");

        javaMailSender.send(mailMessage);

        logger.info("The confirmation e-mail was sent.");
    }

}
