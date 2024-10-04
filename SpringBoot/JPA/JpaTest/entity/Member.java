package com.my.jpaTest.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.util.ObjectUtils;

@Entity
@Data
public class Member {
    @Id
    @Column(nullable = false,
            unique = true)
    private String member_id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public void addTeam(Team team) {
        if (! ObjectUtils.isEmpty(this.team)) {
            this.team.getMemberList().remove(this);
        }
        this.team = team;
        team.getMemberList().add(this);
    }
}
