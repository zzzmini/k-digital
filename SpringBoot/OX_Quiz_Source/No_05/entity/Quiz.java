package com.me.oxQuiz.entity;

import com.me.oxQuiz.constant.Answer;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quiz")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Quiz extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String question;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Answer answer;

    @Column(nullable = false, length = 30)
    private String writer;
}
