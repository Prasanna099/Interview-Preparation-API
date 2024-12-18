package com.example.interviewpreparationtracker.repository;

import com.example.interviewpreparationtracker.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    // Custom query method to find questions by language and difficulty
    List<Question> findByLanguageAndDifficulty(String language, String difficulty);
}
