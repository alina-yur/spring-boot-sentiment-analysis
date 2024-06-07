package com.example.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;

public class Service {
    
    private ChatClient chatClient;

    public Service(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                            .defaultSystem("provide sentiment analysis for user input")
                            .build();
    }

    public String analyse()
    
    {
        return "";
    } 

}
