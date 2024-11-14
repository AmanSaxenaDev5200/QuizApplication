package com.Quiz.quizapp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAnswer {

    private String questionId;
    private String selectedAnswer ;
}
