package com.ex.quizCRUD.dto;

import com.ex.quizCRUD.entity.Member;
import com.ex.quizCRUD.entity.Quiz;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor  // Default 생성자
@AllArgsConstructor
public class MemberDTO {
    private Long no;

    // @Size(min=2, message = "이름은 2자 이상으로 입력해야 합니다.")
    private String id;

    // @Range(min=0, max=120, message = "나이는 0에서 120 사이입니다.")
    private String password;

    // @NotBlank(message = "주소는 꼭 입력해야 합니다.")
    private Boolean status;
    private int answerTrue;
    private int answerFalse;

    private LocalDateTime insertedAt;
    private LocalDateTime updatedAt;

    // Entity -> DTO
    public static MemberDTO fromEntity(Member member){
        return new MemberDTO(
                member.getNo(),
                member.getId(),
                member.getPassword(),
                member.getStatus(),
                member.getAnswerTrue(),
                member.getAnswerFalse(),
                member.getInsertedAt(),
                member.getUpdatedAt()
        );
    }

    // DTO -> Entity
    public static Member fromDTO(MemberDTO dto){
        return new Member(
                dto.getNo(),
                dto.getId(),
                dto.getPassword(),
                dto.getStatus(),
                dto.getAnswerTrue(),
                dto.getAnswerFalse()
        );
    }
}
