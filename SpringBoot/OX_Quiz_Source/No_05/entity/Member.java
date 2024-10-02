package com.me.oxQuiz.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @Column(name="member_id", length = 20, nullable = false)
    private String memberId;
    @Column(length = 20, nullable = false)
    private String password;
    private boolean status;
    private boolean isAdmin;
    @Column(name="answer_true")
    private int answerTrue;
    @Column(name="answer_false")
    private int answerFalse;
}
