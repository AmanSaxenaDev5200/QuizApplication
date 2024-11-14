package com.Quiz.quizapp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "quizzes")
public class Quiz {

    @Id
    private String id;
    private String title;
    private List<Question> questions;
}
