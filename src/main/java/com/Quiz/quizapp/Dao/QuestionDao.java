package com.Quiz.quizapp.Dao;

import com.Quiz.quizapp.Model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionDao extends MongoRepository<Question,String> {
    @Query("{ 'category': ?0 }")
    List<Question> findByCategory(String category);

    void deleteBycategory(String category);

    @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int numQ);
}
