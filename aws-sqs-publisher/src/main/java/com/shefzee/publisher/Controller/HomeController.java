package com.shefzee.publisher.Controller;

import com.shefzee.publisher.publisher.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    MessagePublisher messagePublisher;

    @GetMapping("/send")
    public void send(){
        messagePublisher.sendMessage();
    }
}


