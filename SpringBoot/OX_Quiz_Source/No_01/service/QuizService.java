package com.my.QuizApplication.service;

import com.my.QuizApplication.dto.QuizDTO;
import com.my.QuizApplication.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    public List<QuizDTO> quizList(){
        return quizRepository.findAll().stream().map(quiz -> QuizDTO.fromEntity(quiz)).toList();
    }

    public List<QuizDTO>  quizListByContentAsc() {
        return quizRepository.findAllByContentAsc().stream().map(quiz -> QuizDTO.fromEntity(quiz)).toList();
    }

    public List<QuizDTO>  quizListByContentDesc() {
        return quizRepository.findAllByContentDesc().stream().map(quiz -> QuizDTO.fromEntity(quiz)).toList();
    }

    public List<QuizDTO>  quizListByNameAsc() {
        return quizRepository.findAllByNameAsc().stream().map(quiz -> QuizDTO.fromEntity(quiz)).toList();
    }

    public List<QuizDTO>  quizListByNameDesc() {
        return quizRepository.findAllByNameDesc().stream().map(quiz -> QuizDTO.fromEntity(quiz)).toList();
    }

    public void insertQuiz(QuizDTO dto) {
        quizRepository.save(QuizDTO.fromDTO(dto));
    }

    public QuizDTO findById(Long id){return QuizDTO.fromEntity(quizRepository.findById(id).get());}

    public void updateQuiz(QuizDTO dto){quizRepository.save(QuizDTO.fromDTO(dto));}

    public void deleteQuiz(Long id){quizRepository.deleteById(id);}

    public QuizDTO randomQuiz() {
        QuizDTO result;
        System.out.println(quizRepository.count());
        if(quizRepository.count()==0) {
            result = null;
        } else{
            result = QuizDTO.fromEntity(quizRepository.randomQuiz());
        }
        return result;
    }
}
