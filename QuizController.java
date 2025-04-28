package com.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizapp.model.Question;
import com.quizapp.service.QuizService;

@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/quiz/questions")
    public List<Question> getAllQuestions() {
        return quizService.getAllQuestions();
    }
}
