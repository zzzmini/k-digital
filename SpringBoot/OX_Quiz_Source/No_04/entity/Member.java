package com.ex.quizCRUD.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "member")
@Data
@NoArgsConstructor  // Default 생성자
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Member extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

//    @Column(nullable = false, columnDefinition = "TINYINT")
    // 어떤 방법을 써도, null로 들어감,, 해결방법 더 찾아보기
    // @Column(columnDefinition = "boolean default false")
    private Boolean status;

    // 정답 횟수와 오답 횟수
    private int answerTrue;
    private int answerFalse;
}
