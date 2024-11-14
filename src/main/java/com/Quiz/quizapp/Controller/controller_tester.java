package com.Quiz.quizapp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller_tester {

    @GetMapping("/tester")
    public String tester(){
        String s = new String("quiz on port 8080");
        return s;
    }
}
