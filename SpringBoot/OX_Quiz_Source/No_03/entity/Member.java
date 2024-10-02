package com.example.oxquizproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "member")     //이 이름으로 테이블 생성
public class Member extends BaseEntity {
    @Id     //jakarta.persistence.Id 얘로 어노테이션하기
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    //로그인 정보로 활용한 이메일과 비밀번호 추가
    @Column(length = 20, nullable = false)
    private String id;
    private String password;

    private boolean status;

    private int answerTrue;
    private int answerFalse;
}
