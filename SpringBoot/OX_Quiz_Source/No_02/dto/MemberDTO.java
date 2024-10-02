package com.ex.OXQuiz.dto;

import com.ex.OXQuiz.entity.Member;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Long id;

    // 로그인 정보 - 아이디, 비밀번호
    @NotBlank(message = "아이디를 입력하세요")
    private String memberId;

    @NotBlank(message = "비밀번호를 입력하세요")
    private String memberPassword;

    // 회원 가입 인증 상태
    private Boolean status;

    // 퀴즈 문제 정답
    private int answerTrue;
    private int answerFalse;

    // 추가 필드
    private LocalDateTime insertedAt;
    private LocalDateTime updatedAt;

    // Entity를 DTO로 변환
    public static MemberDTO fromEntity(Member member) {
        return new MemberDTO(
                member.getId(),
                member.getMemberId(),
                member.getMemberPassword(),
                member.getStatus(),
                member.getAnswerTrue(),
                member.getAnswerFalse(),
                member.getInsertedAt(),
                member.getUpdatedAt()
        );
    }

    // DTO를 Entity로 변환
    public static Member fromDTO(MemberDTO dto) {
        return new Member(
                dto.getId(),
                dto.getMemberId(),
                dto.getMemberPassword(),
                dto.getStatus(),
                dto.getAnswerTrue(),
                dto.getAnswerFalse()
        );
    }
}
