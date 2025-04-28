package com.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizapp.model.Question;
import com.quizapp.repository.QuestionRepository;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/submit")
    public int submitAnswers(@RequestBody List<String> userAnswers) {
        List<Question> questions = questionRepository.findAll();
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < userAnswers.size() &&
                questions.get(i).getCorrectAnswer().equalsIgnoreCase(userAnswers.get(i))) {
                score++;
            }
        }
        return score;
    }
}
