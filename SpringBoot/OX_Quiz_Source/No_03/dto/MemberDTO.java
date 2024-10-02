package com.example.oxquizproject.dto;

import com.example.oxquizproject.entity.Member;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Long no;
    @NotBlank(message = "아이디는 꼭 입력해야 합니다.")
    private String id;
    private String password;
    private boolean status;
    private int answerTrue;
    private int answerFalse;

    private LocalDateTime insertedAt;
    private LocalDateTime updatedAt;

    //Entity -> DTO
    public static MemberDTO fromEntity(Member member) {
        return new MemberDTO(
                member.getNo(),
                member.getId(),
                member.getPassword(),
                member.isStatus(),
                member.getAnswerTrue(),
                member.getAnswerFalse(),
                member.getInsertedAt(),
                member.getUpdatedAt()
        );
    }

    //DTO -> Entity
    public static Member fromDTO(MemberDTO dto) {
        return new Member(
                dto.getNo(),
                dto.getId(),
                dto.getPassword(),
                dto.isStatus(),
                dto.getAnswerTrue(),
                dto.getAnswerFalse()
        );
    }
}
