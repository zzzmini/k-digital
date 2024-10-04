package com.my.jpaTest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Team {
    @Id
    @Column(nullable = false, unique = true)
    private String teamId;
    private String teamName;
    @OneToMany(mappedBy = "team",
        fetch = FetchType.EAGER)
    private List<Member> memberList
            = new ArrayList<>();
}
