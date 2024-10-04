package com.my.jpaTest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Parent {
    @Id
    @GeneratedValue
    @Column(name = "parent_id")
    private Long id;
    // 영속성 전이 설정
    @OneToMany(mappedBy = "parent"
            , cascade = {CascadeType.PERSIST,
                        CascadeType.REMOVE})
    private List<Child> children = new ArrayList<>();
}
