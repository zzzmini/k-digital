package com.ex.quizCRUD.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quiz")
@Data
@NoArgsConstructor  // Default 생성자
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Quiz extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 퀴즈 내용
    @Column(length = 500, nullable = false)
    private String content;

    // 해답 true:O, false:X  >> Boolean 처리는 안되는지?
    @Column(length = 10, nullable = false)
    private String answer;

    // 작성자
    @Column(length = 30)
    private String writer;
}