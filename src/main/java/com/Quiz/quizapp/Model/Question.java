package com.Quiz.quizapp.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String options4;
    private String rightAnswer;
    private String difficultylevel;
    private String category;

}
