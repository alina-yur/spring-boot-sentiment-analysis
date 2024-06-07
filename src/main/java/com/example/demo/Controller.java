package com.example.demo;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controller {

     @Autowired
    private Service Service;


    @GetMapping("/")
    public String form(Model model) {
        return "form";
    }
    
    private final ChatClient chatClient;

    public Controller(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                            .defaultSystem("provide sentiment analysis for user input")
                            .build();
    }

    @PostMapping("/analysis")
    public String sentiment_analysis (@RequestParam String user_input, Model model) {
        String sentiment_analysis = Service.analyse(user_input);
        System.out.println();
        model.addAttribute("sentiment_analysis", sentiment_analysis);
        return "result";
    }

}
