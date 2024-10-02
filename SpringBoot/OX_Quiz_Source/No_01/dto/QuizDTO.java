package com.my.QuizApplication.dto;

import com.my.QuizApplication.entity.Quiz;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDTO {
    private Long id;
    private @NotBlank(
        message = "공백일 수 없습니다"
    ) String content;
    private Boolean answer;
    private String name;
    private LocalDateTime insertedAt;
    private LocalDateTime updatedAt;

    public static Quiz fromDTO(QuizDTO dto) {
        return new Quiz(
                dto.getId(),
                dto.getContent(),
                dto.getAnswer(),
                dto.getName()
        );
    }

    public static QuizDTO fromEntity(Quiz quiz) {
        return new QuizDTO(
                quiz.getId(),
                quiz.getContent(),
                quiz.getAnswer(),
                quiz.getName(),
                quiz.getInsertedAt(),
                quiz.getUpdatedAt()
        );
    }
}
