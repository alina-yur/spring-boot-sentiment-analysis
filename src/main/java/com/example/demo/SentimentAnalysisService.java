package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.ai.chat.client.ChatClient;

@Service
public class SentimentAnalysisService {

    private final ChatClient chatClient;

    public SentimentAnalysisService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String analyse(String userInput) {
        final String systemPrompt = "provide sentiment analysis for user input";
        String fullPrompt = systemPrompt + " " + userInput;

        return this.chatClient.prompt()
                        .user(fullPrompt)
                        .call()
                        .content();
    }
}
