package com.ex.OXQuiz.dto;

import com.ex.OXQuiz.entity.Quiz;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {
    private Long id;

    @NotBlank(message = "퀴즈 내용을 입력하세요.")
    private String content;

    @NotNull(message = "퀴즈의 답을 입력하세요.")
    private String answer;

    @NotBlank(message = "작성자를 입력하세요.")
    private String writer;

    private LocalDateTime insertedAt;
    private LocalDateTime updatedAt;

    //Entity to DTO
    public static QuizDTO fromEntity(Quiz quiz) {
        return new QuizDTO(quiz.getId(), quiz.getContent(), quiz.getAnswer(), quiz.getWriter(),
                quiz.getInsertedAt(), quiz.getUpdatedAt());
    }

    //DTO to Entity
    public static Quiz fromDTO(QuizDTO dto) {
        return new Quiz(dto.getId(), dto.getContent(), dto.getAnswer(), dto.getWriter());
    }
}
