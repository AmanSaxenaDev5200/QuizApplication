package com.Quiz.quizapp.Model;


import lombok.Data;



@Data

public class QuestionWrapper {

    private String id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String options4;

    public QuestionWrapper(String id, String questionTitle, String option1, String option2, String option3, String options4) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.options4 = options4;
    }
}
