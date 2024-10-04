package com.my.jpaTest.service;

import com.my.jpaTest.entity.Member;
import com.my.jpaTest.entity.Team;
import com.my.jpaTest.repository.TeamRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationTestService {
    @Autowired
    EntityManager em;



    @Transactional
    public void insertMemberAndTeam() {
        Member jang = new Member();
        jang.setMember_id("jang");
        jang.setName("장원영");
//        jang.setTeamId("ive");
        em.persist(jang);

        Team ive = new Team();
        ive.setTeamId("ive");
        ive.setTeamName("아이브");
        em.persist(ive);
    }

    @Transactional
    public void insertRelationData() {
        Team ive = new Team();
        ive.setTeamId("ive");
        ive.setTeamName("아이브");
        em.persist(ive);

        Member jang = new Member();
        jang.setMember_id("jang");
        jang.setName("장원영");
        jang.setTeam(ive);
        em.persist(jang);
    }

    @Transactional
    public void insertBothDirectionDataInput() {
        // 뉴진스 팀을 생성
        Team newJeans = new Team();
        newJeans.setTeamId("newJeans");
        newJeans.setTeamName("뉴진스");
        em.persist(newJeans);

        // 민지를 추가
        Member minji = new Member();
        minji.setMember_id("minji");
        minji.setName("민지");
        minji.setTeam(newJeans);
        em.persist(minji);
        // 다니엘 추가
        Member daniel = new Member();
        daniel.setMember_id("daniel");
        daniel.setName("다니엘");
        daniel.setTeam(newJeans);
        em.persist(daniel);
    }

    @Transactional
    public void insertIveMembers() {
        // 뉴진스 팀을 생성
        Team ive = new Team();
        ive.setTeamId("ive");
        ive.setTeamName("아이브");
        em.persist(ive);

        // 민지를 추가
        Member jang = new Member();
        jang.setMember_id("jang");
        jang.setName("장원영");
        jang.setTeam(ive);
        em.persist(jang);
        // 다니엘 추가
        Member ahn = new Member();
        ahn.setMember_id("ahn");
        ahn.setName("안유진");
        ahn.setTeam(ive);
        em.persist(ahn);
    }

    @Transactional
    public void insertSSirumTeamAndMember() {
        // 강호동
        Member gang = new Member();
        gang.setMember_id("gang");
        gang.setName("강호동");
        em.persist(gang);

        // 이만기
        Member lee = new Member();
        lee.setMember_id("lee");
        lee.setName("이만기");
        em.persist(lee);

        Team team = new Team();
        team.setTeamId("ssirum");
        team.setTeamName("씨름팀");
        team.getMemberList().add(gang);
        team.getMemberList().add(lee);
        em.persist(team);
    }

    @Transactional
    public void insertBlackPink() {
        // 팀을 생성
        Team blackPink = new Team();
        blackPink.setTeamId("blackPink");
        blackPink.setTeamName("블랙핑크");
        em.persist(blackPink);

        // 멤버를 생성(Lisa, Jenny) - 팀 할당
        Member lisa = new Member();
        lisa.setMember_id("lisa");
        lisa.setName("리사");
        lisa.addTeam(blackPink);
//        lisa.setTeam(blackPink);
//        blackPink.getMemberList().add(lisa);
        em.persist(lisa);

        Member jenny = new Member();
        jenny.setMember_id("jenny");
        jenny.setName("제니");
//        jenny.setTeam(blackPink);
//        blackPink.getMemberList().add(jenny);
        jenny.addTeam(blackPink);
        em.persist(jenny);

    }
}
