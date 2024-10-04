package com.my.jpaTest.entity;

import com.my.jpaTest.constant.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "like_color")
    private String likeColor;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
