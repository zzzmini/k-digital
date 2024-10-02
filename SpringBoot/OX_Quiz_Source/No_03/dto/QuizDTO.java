package com.example.oxquizproject.dto;

import com.example.oxquizproject.entity.Quiz;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {
    private Long id;

    @NotBlank(message = "공백일 수 없습니다")
    private String content;

    private String answer;
    private String name;

    //Entity -> DTO
    public static QuizDTO fromEntity(Quiz quiz) {
        return new QuizDTO(
                quiz.getId(),
                quiz.getContent(),
                quiz.getAnswer(),
                quiz.getName()
        );
    }

    //DTO -> Entity
    public static Quiz fromDTO(QuizDTO dto) {
        return new Quiz(
                dto.getId(),
                dto.getContent(),
                dto.getAnswer(),
                dto.getName()
        );
    }
}
