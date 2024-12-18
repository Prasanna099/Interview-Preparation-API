package com.example.interviewpreparationtracker.controller;

import com.example.interviewpreparationtracker.model.Question;
import com.example.interviewpreparationtracker.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        Question savedQuestion = questionService.addQuestion(question);
        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        // Correctly unwrapping the Optional and returning the Question if present
        Question question = questionService.getQuestionById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        Question updatedQuestion = questionService.updateQuestion(id, question);
        return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public List<Question> searchQuestions(@RequestParam String language, @RequestParam String difficulty) {
        return questionService.searchQuestions(language, difficulty);
    }
}
