package com.me.oxQuiz.service;

import com.me.oxQuiz.dto.QuizDTO;
import com.me.oxQuiz.entity.Quiz;
import com.me.oxQuiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    public List<QuizDTO> findAll(){
        return quizRepository.findAll()
                .stream()
                .map(entity-> QuizDTO.fromEntity(entity))
                .toList();
    }

    public List<QuizDTO> findRandomOne(){
        return quizRepository.searchRandomOne()
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

    public QuizDTO findById(Long id) {
        Quiz quiz = quizRepository.findById(id).get();
        return QuizDTO.fromEntity(quiz);
    }

    public void updateQuiz(QuizDTO dto) {
        Quiz quiz = QuizDTO.fromDTO(dto);
        quizRepository.save(quiz);
    }
}
