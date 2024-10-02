package com.ex.OXQuiz.service;

import com.ex.OXQuiz.dto.QuizDTO;
import com.ex.OXQuiz.entity.Quiz;
import com.ex.OXQuiz.repository.QuizRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuizService {
    private final QuizRepository quizRepository;

    public List<QuizDTO> findAll() {
        return quizRepository.findAll().stream().map(entity -> QuizDTO.fromEntity(entity)).toList();
    }


    public void insertQuiz(QuizDTO dto) {
        quizRepository.save(QuizDTO.fromDTO(dto));
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    public QuizDTO findById(Long id) {
        return QuizDTO.fromEntity(quizRepository.findById(id).get());
    }

    public void updateQuiz(QuizDTO dto) {
        quizRepository.save(QuizDTO.fromDTO(dto));
    }

    public QuizDTO findRandom() {
        return QuizDTO.fromEntity(quizRepository.findRandom());
    }
}
