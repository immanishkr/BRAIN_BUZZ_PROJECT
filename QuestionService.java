package com.quizapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.quizapp.model.Question;
import com.quizapp.repository.QuestionRepository;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestion(Long id, Question updatedQuestion) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            Question question = optionalQuestion.get();
            question.setQuestionText(updatedQuestion.getQuestionText());
            question.setOptionA(updatedQuestion.getOptionA());
            question.setOptionB(updatedQuestion.getOptionB());
            question.setOptionC(updatedQuestion.getOptionC());
            question.setOptionD(updatedQuestion.getOptionD());
            question.setCorrectAnswer(updatedQuestion.getCorrectAnswer());
            return questionRepository.save(question);
        } else {
            return null; // or throw an exception if you prefer
        }
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
