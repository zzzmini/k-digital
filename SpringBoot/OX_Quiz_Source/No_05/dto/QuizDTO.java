package com.me.oxQuiz.dto;

import com.me.oxQuiz.constant.Answer;
import com.me.oxQuiz.entity.Quiz;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDTO {
    private Long id;
    @NotBlank(message = "문제를 입력해주세요.")
    private String question;
    @NotNull(message = "정답을 입력해주세요.")
    private Answer answer;
    @NotBlank(message = "작성자를 입력해주세요.")
    private String writer;
    private LocalDateTime insertedAt;
    private LocalDateTime updatedAt;

    // Entity -> DTO
    public static QuizDTO fromEntity(Quiz quiz) {
        return new QuizDTO(
                quiz.getId(),
                quiz.getQuestion(),
                quiz.getAnswer(),
                quiz.getWriter(),
                quiz.getInsertedAt(),
                quiz.getUpdatedAt()
        );
    }

    // DTO -> Entity
    public static Quiz fromDTO(QuizDTO dto) {
        return new Quiz(
                dto.getId(),
                dto.getQuestion(),
                dto.getAnswer(),
                dto.getWriter()
        );
    }

}
