package com.example.interviewpreparationtracker;

import com.example.interviewpreparationtracker.model.Question;
import com.example.interviewpreparationtracker.repository.QuestionRepository;
import com.example.interviewpreparationtracker.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

class QuestionServiceTests {

    @InjectMocks
    private QuestionService questionService;

    @Mock
    private QuestionRepository questionRepository;

    private Question question;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        question = new Question();
        question.setId(1L);
        question.setQuestionText("What is Java?");
        question.setLanguage("Java");
        question.setDifficulty("Easy");
        question.setTags(List.of("Java", "OOP"));  // Use List.of() for tags
    }

    @Test
    void testAddQuestion() {
        when(questionRepository.save(question)).thenReturn(question);

        Question savedQuestion = questionService.addQuestion(question);

        assertNotNull(savedQuestion);
        assertEquals("What is Java?", savedQuestion.getQuestionText());
        verify(questionRepository, times(1)).save(question);
    }

    @Test
    void testGetQuestionById() {
        when(questionRepository.findById(1L)).thenReturn(Optional.of(question));

        Question foundQuestion = questionService.getQuestionById(1L);

        assertNotNull(foundQuestion);
        assertEquals(1L, foundQuestion.getId());
        verify(questionRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateQuestion() {
        Question updatedQuestion = new Question();
        updatedQuestion.setQuestionText("What is OOP?");
        updatedQuestion.setLanguage("Java");
        updatedQuestion.setDifficulty("Medium");
        updatedQuestion.setTags(List.of("Java", "OOP"));

        when(questionRepository.findById(1L)).thenReturn(Optional.of(question));
        when(questionRepository.save(any(Question.class))).thenReturn(updatedQuestion);

        Question result = questionService.updateQuestion(1L, updatedQuestion);

        assertNotNull(result);
        assertEquals("What is OOP?", result.getQuestionText());
        verify(questionRepository, times(1)).save(any(Question.class));
    }

    @Test
    void testDeleteQuestion() {
        when(questionRepository.findById(1L)).thenReturn(Optional.of(question));

        questionService.deleteQuestion(1L);

        verify(questionRepository, times(1)).deleteById(1L);
    }

    @Test
    void testSearchQuestions() {
        when(questionRepository.findByLanguageAndDifficulty("Java", "Easy")).thenReturn(List.of(question));

        List<Question> questions = questionService.searchQuestions("Java", "Easy");

        assertNotNull(questions);
        assertEquals(1, questions.size());
        verify(questionRepository, times(1)).findByLanguageAndDifficulty("Java", "Easy");
    }
}
