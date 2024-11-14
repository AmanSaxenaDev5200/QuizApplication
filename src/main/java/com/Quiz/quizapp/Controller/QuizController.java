package com.Quiz.quizapp.Controller;

import com.Quiz.quizapp.Model.Question;
import com.Quiz.quizapp.Model.QuestionWrapper;
import com.Quiz.quizapp.Model.UserQuizSubmission;
import com.Quiz.quizapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> CreateQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizService.CreateQuiz(category,numQ,title);
    }

    @GetMapping("/get/{id}")
   public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable String id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submit")
    public ResponseEntity<?> submitQuizAnswers(@RequestBody UserQuizSubmission submission) {
        return quizService.submitQuizAnswers(submission);
    }
}
//http://localhost:8080/quiz/create?category=Java&numQ=5&title=Java this is how we gonna call the method in the postman


