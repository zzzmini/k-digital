package com.me.oxQuiz.service;

import com.me.oxQuiz.dto.MemberDTO;
import com.me.oxQuiz.entity.Member;
import com.me.oxQuiz.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<MemberDTO> findAll() {
        return memberRepository.findAll()
                .stream()
                .map(entity-> MemberDTO.fromEntity(entity))
                .toList();
    }

    // 중복 ID 검사
    public boolean isDuplicateMemberId(String memberId){
        return memberRepository.findByMemberId(memberId).isPresent();
    }

    public String saveMember(MemberDTO dto) {
        // 관리자 설정
        if("root".equals(dto.getMemberId()) && "admin".equals(dto.getPassword())){
            dto.setAdmin(true); // 관리자
            dto.setStatus(true);
        } else {
            dto.setAdmin(false); // 일반 사용자
        }
        memberRepository.save(MemberDTO.fromDTO(dto));
        return null;
    }

    public MemberDTO findById(Long no) {
        Member member = memberRepository.findById(no).get();
        return MemberDTO.fromEntity(member);
    }

    public void updateMember(MemberDTO dto){
        Member member = MemberDTO.fromDTO(dto);
        memberRepository.save(member);
    }

    public void verifyMember(Long no) {
        Member member = memberRepository.findById(no).get();
        member.setStatus(true);
        memberRepository.save(member);
    }

    public void deactivateMember(Long no) {
        Member member = memberRepository.findById(no).get();
        member.setStatus(false);
        memberRepository.save(member);
    }

    // 로그인
    public String findByUserId(MemberDTO dto) {
        Member member = memberRepository
                .findByMemberId(dto.getMemberId())
                .orElse(null);
        if (ObjectUtils.isEmpty(member)){
            return null; // ID 없는 경우
        } else {
            if(!member.getPassword().equals(dto.getPassword())){
                return null; // 비밀번호 틀린 경우
            } else if (!member.isStatus()){ // status가 false인 경우
                return "inactive";
            } else {
                return member.getMemberId(); // 정상 로그인
            }
        }
    }

    // 관리자 확인
    public boolean isAdmin(String myId) {
        Member member = memberRepository.findByMemberId(myId).orElse(null);
        return member != null && member.isAdmin();
    }

    // 정답 카운트 증가
    public void incrementAnswerTrue(String myId) {
        Member member = memberRepository.findByMemberId(myId).orElse(null);
        member.setAnswerTrue(member.getAnswerTrue()+1);
        memberRepository.save(member);
    }

    // 오답 카운트 증가
    public void incrementAnswerFalse(String myId) {
        Member member = memberRepository.findByMemberId(myId).orElse(null);
        member.setAnswerFalse(member.getAnswerFalse()+1);
        memberRepository.save(member);

    }
}
