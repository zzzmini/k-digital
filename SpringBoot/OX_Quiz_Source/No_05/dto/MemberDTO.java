package com.me.oxQuiz.dto;

import com.me.oxQuiz.entity.Member;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Long no;
    @NotBlank(message = "ID는 필수 입력사항입니다.")
    private String memberId;
    @NotBlank(message = "비밀번호는 필수 입력사항입니다.")
    private String password;
    private String confirmPassword; // 비밀번호 확인 필드
    private boolean status;
    private boolean isAdmin; // 관리자 여부 필드
    private int answerTrue;
    private int answerFalse;
    private LocalDateTime insertedAt;
    private LocalDateTime updatedAt;

    // Entity -> DTO
    public static MemberDTO fromEntity(Member member) {
        return new MemberDTO(
                member.getNo(),
                member.getMemberId(),
                member.getPassword(),
                null,
                member.isStatus(),
                member.isAdmin(),
                member.getAnswerTrue(),
                member.getAnswerFalse(),
                member.getInsertedAt(),
                member.getUpdatedAt()
        );
    }

    //  DTO -> Entity
    public static Member fromDTO(MemberDTO dto){
        return new Member(
                dto.getNo(),
                dto.getMemberId(),
                dto.getPassword(),
                dto.isStatus(),
                dto.isAdmin(),
                dto.getAnswerTrue(),
                dto.getAnswerFalse()
        );
    }
}
