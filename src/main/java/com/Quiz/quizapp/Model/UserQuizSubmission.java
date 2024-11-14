package com.Quiz.quizapp.Model;

import lombok.Data;

import java.util.List;

@Data
public class UserQuizSubmission {
    private String quizId;
    private List<UserAnswer> answers;
}
