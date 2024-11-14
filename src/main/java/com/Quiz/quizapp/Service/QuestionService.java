package com.Quiz.quizapp.Service;

import com.Quiz.quizapp.Dao.QuestionDao;
import com.Quiz.quizapp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService  {

    @Autowired
    QuestionDao questiondao;

//    Get all the Questions
    public ResponseEntity<List<Question>> getAllquestions() {
        try {
            return new ResponseEntity<>(questiondao.findAll(), HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionbyCategory(String category) {
        try {
            return new ResponseEntity<>(questiondao.findByCategory(category), HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public String saveQuestion(Question question) {
        questiondao.save(question);
        String s = new String("Question is added in the database successfully");
        return s;
    }

    public List<Question> saveAllQuestions(List<Question> questions) {
        return questiondao.saveAll(questions);
    }

    public void delete(String category) {
        questiondao.deleteBycategory(category);
    }

//
}
