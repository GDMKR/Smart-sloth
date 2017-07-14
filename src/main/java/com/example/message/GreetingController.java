package com.example.message;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {


    @MessageMapping("/chat")
    @SendTo("/topic/message")
    public Message sendAnswer(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return message;
    }

}
