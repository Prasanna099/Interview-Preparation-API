package com.example.interviewpreparationtracker.service;

import com.example.interviewpreparationtracker.exception.ResourceNotFoundException;
import com.example.interviewpreparationtracker.model.Question;
import com.example.interviewpreparationtracker.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with id: " + id));
    }

    public Question updateQuestion(Long id, Question updatedQuestion) {
        // Fetch the existing question from the repository
        Question existingQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with id: " + id));

        // Update the existing question with new values
        existingQuestion.setQuestionText(updatedQuestion.getQuestionText());
        existingQuestion.setLanguage(updatedQuestion.getLanguage());
        existingQuestion.setDifficulty(updatedQuestion.getDifficulty());
        existingQuestion.setTags(updatedQuestion.getTags());

        // Save the updated question and return it
        return questionRepository.save(existingQuestion); // This ensures the value is used and saved
    }

    public void deleteQuestion(Long id) {
        // Check if the question exists before deleting
        questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with id: " + id));

        questionRepository.deleteById(id); // Delete the question by ID
    }

    public List<Question> searchQuestions(String language, String difficulty) {
        // Call repository method to search questions by language and difficulty
        return questionRepository.findByLanguageAndDifficulty(language, difficulty);
    }
}
