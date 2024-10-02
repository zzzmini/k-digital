package com.ex.quizCRUD.service;

import com.ex.quizCRUD.dto.QuizDTO;
import com.ex.quizCRUD.entity.Quiz;
import com.ex.quizCRUD.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    public List<QuizDTO> findAll(){
        return quizRepository.findAll().stream().map(entity->QuizDTO.fromEntity(entity)).toList();
    }

    public void saveQuiz(QuizDTO dto) {
        quizRepository.save(QuizDTO.fromDTO(dto));
    }

    public QuizDTO findById(Long id) {
        Quiz quiz = quizRepository.findById(id).get();
        return QuizDTO.fromEntity(quiz);
    }

    public void updateQuiz(QuizDTO dto) {
        quizRepository.save(QuizDTO.fromDTO(dto));
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    public QuizDTO randQuiz() {
        Quiz quiz = quizRepository.randQuiz();
        if(!ObjectUtils.isEmpty(quiz)) {
            return QuizDTO.fromEntity(quiz);
        }else{
            return null;
        }
    }
}
