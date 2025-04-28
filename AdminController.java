package com.quizapp.controller;

import com.quizapp.model.Question;
import com.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private QuestionService questionService;

    // Add a question
    @PostMapping("/add-question")
    public Question addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    // Get all questions
    @GetMapping("/all-questions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    // Update a question
    @PutMapping("/update-question/{id}")
    public Question updateQuestion(@PathVariable Long id, @RequestBody Question updatedQuestion) {
        return questionService.updateQuestion(id, updatedQuestion);
    }

    // Delete a question
    @DeleteMapping("/delete-question/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return "Question deleted with id: " + id;
    }
}
