package com.learn.springwebsocket.controller;

import com.learn.springwebsocket.Greeting;
import com.learn.springwebsocket.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws InterruptedException {
        Thread.sleep(2000);
        return new Greeting("Hello, " + message.getName() + "!");
    }
}
