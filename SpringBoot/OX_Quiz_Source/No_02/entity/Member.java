package com.ex.OXQuiz.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Member extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //로그인 정보 - 아이디, 비밀번호
    @Column(name = "member_id", nullable = false, updatable = false)
    private String memberId;
    @Column(name = "member_password", nullable = false)
    private String memberPassword;

    // 회원 가입 인증 상태
    private Boolean status;

    // 퀴즈 문제 정답
    private int answerTrue;
    private int answerFalse;
}