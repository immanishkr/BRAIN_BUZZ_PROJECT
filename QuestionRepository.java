package com.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizapp.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
