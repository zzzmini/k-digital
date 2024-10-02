package com.my.QuizApplication.dto;

import com.my.QuizApplication.entity.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Long no;
    private @NotBlank(
            message = "입력해주세요."
    )String memberId;
    private
    @Length(min = 4, max = 10, message = "4-10자리로 입력해주세요.")
    String password;
    private Boolean status=false;
    private int answerTrue=0;
    private int answerFalse=0;
    private LocalDateTime insertedAt;
    private LocalDateTime updatedAt;

    public static MemberDTO fromEntity(Member member) {
        return new MemberDTO(
                member.getNo(),
                member.getMemberId(),
                member.getPassword(),
                member.getStatus(),
                member.getAnswerTrue(),
                member.getAnswerFalse(),
                member.getInsertedAt(),
                member.getUpdatedAt()
        );
    }

    public static Member fromDTO(MemberDTO dto) {
        return new Member(
                dto.getNo(),
                dto.getMemberId(),
                dto.getPassword(),
                dto.getStatus(),
                dto.getAnswerTrue(),
                dto.getAnswerFalse()
        );
    }
}
