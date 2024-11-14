package com.Quiz.quizapp.Dao;

import com.Quiz.quizapp.Model.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface QuizDao extends MongoRepository<Quiz, String> {
//    Optional<Quiz> findById(String id);
}
