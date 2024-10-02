package com.ex.quizCRUD.dto;

import com.ex.quizCRUD.entity.Quiz;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor  // Default 생성자
@AllArgsConstructor
public class QuizDTO {
    private Long id;

    @NotBlank(message = "퀴즈 내용은 공백일 수 없습니다")
    private String content;
    private String answer;
    private String writer;

    private LocalDateTime insertedAt;
    private LocalDateTime updatedAt;

    // entity > dto
    public static QuizDTO fromEntity(Quiz quiz){
        return new QuizDTO(
          quiz.getId(),
          quiz.getContent(),
          quiz.getAnswer(),
          quiz.getWriter(),
          quiz.getInsertedAt(),
          quiz.getUpdatedAt()
        );
    }

    // dto > entity
    public static Quiz fromDTO(QuizDTO dto){
        return new Quiz(
                dto.getId(),
                dto.getContent(),
                dto.getAnswer(),
                dto.getWriter()
        );
    }
}
