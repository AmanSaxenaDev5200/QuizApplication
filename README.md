# Quiz-Application
This project is a Spring Boot application for managing quizzes, with MongoDB as the database. It provides APIs to create quizzes, get quiz questions, and submit answers. Follow these steps to set up and test the application with Postman.


API Endpoints
1. Create a Quiz
Endpoint: POST /quiz/create

Description: Creates a new quiz with questions from a specific category.

URL Example: http://localhost:8080/quiz/create?category=Java&numQ=5&title=Java Basics

Parameters:

category (String): The category of questions (e.g., "Java").
numQ (int): Number of questions to include in the quiz.
title (String): Title of the quiz.
Postman Setup:

Method: POST
URL: http://localhost:8080/quiz/create
Add Query Parameters:
category: Java
numQ: 5
title: Java Basics
Response:

Status: 201 Created
Body: "Success"
2. Get Quiz Questions
Endpoint: GET /quiz/get/{id}

Description: Retrieves the questions of a specific quiz by quiz ID.

URL Example: http://localhost:8080/quiz/get/{quizId}

Parameters:

{id} (Path Variable): The ID of the quiz to retrieve questions.
Postman Setup:

Method: GET
URL: http://localhost:8080/quiz/get/{quizId}
Replace {quizId} with the actual quiz ID from the response of the Create Quiz request.
Response:

Status: 200 OK
Body: List of questions with options (without correct answers).
3. Submit Quiz Answers
Endpoint: POST /quiz/submit

Description: Submit answers for a quiz and get the score.

URL Example: http://localhost:8080/quiz/submit

Request Body Example:

json
Copy code
{
  "quizId": "quizIdHere",
  "answers": [
    {"questionId": "q1Id", "selectedAnswers": "OptionA"},
    {"questionId": "q2Id", "selectedAnswers": "OptionB"},
    // Add answers for each question
  ]
}
Parameters:

quizId (String): The ID of the quiz being answered.
answers (Array): A list of answers, each with:
questionId (String): The ID of the question.
selectedAnswers (String): The answer chosen by the user.
Postman Setup:

Method: POST
URL: http://localhost:8080/quiz/submit
In the Body tab, select raw, and set type to JSON, then paste the above JSON example with your quizId and corresponding answers.
Response:

Status: 200 OK
Body: "You scored X out of Y (Z%)" where X is the correct count, Y is the total, and Z is the percentage score.
