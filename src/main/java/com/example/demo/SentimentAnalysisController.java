package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SentimentAnalysisController {

    @GetMapping("/")
    public String form(Model model) {
        return "form";
    }

    @PostMapping("/analysis")
    public String sentimentAnalysis(@RequestParam("user_input") String userInput, Model model) {
        String sentimentAnalysis = SentimentAnalysisService.analyse(userInput);
        model.addAttribute("sentiment_analysis", sentimentAnalysis);
        return "result";
    }
}
