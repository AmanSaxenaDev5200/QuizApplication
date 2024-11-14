package com.Quiz.quizapp.Service;

import com.Quiz.quizapp.Dao.QuestionDao;
import com.Quiz.quizapp.Dao.QuizDao;
import com.Quiz.quizapp.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizdao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> CreateQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizdao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(String id) {
        Optional<Quiz> optionalQuiz = quizdao.findById(id);

        if (optionalQuiz.isEmpty() || optionalQuiz.get().getQuestions() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Quiz quiz = optionalQuiz.get();

        List<Question> questionsFromDB = quiz.getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question q :questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOptions4());
            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<?> submitQuizAnswers(UserQuizSubmission submission){
        Optional<Quiz> quizOptional = quizdao.findById(submission.getQuizId());

        if (quizOptional.isEmpty()) {
            return new ResponseEntity<>("quiz not found", HttpStatus.NOT_FOUND);
        }

        Quiz quiz = quizOptional.get();
        int correctCount = 0;
        int totalQuestions = quiz.getQuestions().size();

        for (UserAnswer userAnswer : submission.getAnswers()) {
            Optional<Question> questionOptional = questionDao.findById(userAnswer.getQuestionId());

            if (questionOptional.isPresent()) {
                Question question = questionOptional.get();
                // Check if the user's answer matches the correct answer
                if (question.getRightAnswer().equals(userAnswer.getSelectedAnswer())) {
                    correctCount++;
                }
            }
        }

        // Calculate score and return response
        double score = (double) correctCount / totalQuestions * 100;
        String result = "You scored " + correctCount + " out of " + totalQuestions + " (" + score + "%)";

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

