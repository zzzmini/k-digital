package com.my.jpaTest.service;

import com.my.jpaTest.entity.Member;
import com.my.jpaTest.entity.Team;
import com.my.jpaTest.repository.TeamRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RelationTestServiceTest {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    EntityManager em;

    @Autowired
    RelationTestService relationTestService;

    @Test
    void insertMemberAndTeamTest() {
        relationTestService.insertMemberAndTeam();
    }

    // 장원영의 팀 이름을 알고 싶어요
    @Test
    void searchMemberTeamName() {
        Member jang = em.find(Member.class, "jang");
//        Team ive = em.find(Team.class, jang.getTeamId());
//        System.out.println("Team name : " + ive.getTeamName());
    }

    @Test
    void TeamMemberSave() {
        relationTestService.insertRelationData();
    }

    @Test
    void jangWonYoungTeamSearch() {
        Member jang = em.find(Member.class, "jang");
        System.out.println("장원영 팀 : " +
                jang.getTeam().getTeamName());
    }

    @Test
    void insertBothDirectionDataInput() {
        relationTestService.insertBothDirectionDataInput();
    }

    @Test
    void insertIveMembers() {
        relationTestService.insertIveMembers();
    }

    @Test
    void newJeansMemberPrint() {
        Team newJeans = em.find(Team.class, "newJeans");
        List<Member> memberList =
                newJeans.getMemberList();
        System.out.println("size = " + memberList.size());
        for (Member m : memberList) {
            System.out.println("-------" + m.getName());
        }
    }

    @Test
    void insertSSirumTeamAndMember() {
        relationTestService.insertSSirumTeamAndMember();
    }

    @Test
    void insertBlackPink() {
        relationTestService.insertBlackPink();
    }

    @Test
    void searchingMemberList() {
        // 팀 이름과 아이돌 이름
        List<Team> teams = teamRepository.findAll();
        // 아이브 - 장원영
        // 블랙핑크 - 제니
        for (Team team : teams) {
            for (Member member : team.getMemberList()) {
                System.out.println(team.getTeamName() + " - " +
                        member.getName());
            }
        }
    }
}