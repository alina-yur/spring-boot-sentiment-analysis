package com.example.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;

public class Controller {
    
    private final ChatClient chatClient;

    public Controller(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                            .defaultSystem("provide sentiment analysis for user input")
                            .build();
    }

/*     @GetMapping("/ai")
    String generation(String userInput) {
        return this.chatClient.prompt()
            .user(userInput)
            .call()
            .content();
    } */

}
