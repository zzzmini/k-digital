package com.example.oxquizproject.service;

import com.example.oxquizproject.dto.QuizDTO;
import com.example.oxquizproject.entity.Quiz;
import com.example.oxquizproject.repository.OXQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final OXQuizRepository quizRepository;

    public QuizDTO findById(Long id) {
        Quiz quiz = quizRepository.findById(id).get();
        return QuizDTO.fromEntity(quiz);
    }

    public List<QuizDTO> findAll() {
        return quizRepository.searchAll()
                .stream()
                .map(entity -> QuizDTO.fromEntity(entity))
                .toList();
    }

    public void saveQuiz(QuizDTO dto) {
        quizRepository.save(QuizDTO.fromDTO(dto));

    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    public void updateQuiz(QuizDTO dto) {
        Quiz quiz = QuizDTO.fromDTO(dto);
        quizRepository.save(quiz);
    }

    public List<QuizDTO> randomQuiz() {
        return quizRepository.randQuiz().stream().map(entity -> QuizDTO.fromEntity(entity)).toList();
    }
}
