package com.Quiz.quizapp.Controller;

import com.Quiz.quizapp.Model.Question;
import com.Quiz.quizapp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllquestions(){
        return questionService.getAllquestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionbyCategory(category);
    }

//    code to add the question
    @PostMapping("/addquestion")
    public String addQuestion(@RequestBody Question question){
        return questionService.saveQuestion(question);
    }

//    code the add the questions
    @PostMapping("/addquestions")
    public List<Question> addQuestions(@RequestBody List<Question> questions){
        return questionService.saveAllQuestions(questions);
    }

//    Delete the product by category
    @DeleteMapping("/delete/{category}")
    public String delete(@PathVariable String category){
        questionService.delete(category);
        String s = "Question with the " + category + "have been deleted";
        return s;
    }
}
