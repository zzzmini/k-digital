package com.my.QuizApplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="member")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Member extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @Column(nullable = false)
    private String memberId;
    @Column(nullable = false)
    private String password;
    @Column(name = "status")
    private Boolean status = false;
    @Column(name = "answer_true")
    private int answerTrue =0;
    @Column(name = "answer_false")
    private int answerFalse =0;
}
