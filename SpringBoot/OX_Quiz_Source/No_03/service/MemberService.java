package com.example.oxquizproject.service;

import com.example.oxquizproject.dto.MemberDTO;
import com.example.oxquizproject.dto.QuizDTO;
import com.example.oxquizproject.entity.Member;
import com.example.oxquizproject.entity.Quiz;
import com.example.oxquizproject.repository.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public int saveMember(MemberDTO dto) {
        // 아이디가 'root'이고 비밀번호가 'admin'인 경우 관리자로 임명
        if (dto.getId().equals("root") && dto.getPassword().equals("admin")) {
            // root/admin으로 이미 등록된 관리자가 있는지 확인
            if (memberRepository.existsByIdAndPassword("root", "admin")) {
                return 1; // 이미 존재하는 경우 1 반환
            } else {
                dto.setStatus(true);  // 관리자로 status 설정
                memberRepository.save(MemberDTO.fromDTO(dto));
                return 0;  // 정상 등록 시 0 반환
            }
        } else {
            // 새로운 멤버 저장
            memberRepository.save(MemberDTO.fromDTO(dto));
            return 0;  // 정상 등록 시 0 반환
        }
    }


    public String findById(MemberDTO dto) {
        Member member = memberRepository.findById(dto.getId()).orElse(null);
        if (ObjectUtils.isEmpty(member)) {
            //로그인 실패
            return "wrong";
        } else {
            //아이디 찾기 성공
            if (member.getPassword().equals(dto.getPassword())) {
                //비밀번호 찾기 성공
                if (member.isStatus()){
                    //status가 true면
                    return member.getId();
                } else {
                    return null;
                }
            } else {
                //비밀번호 안맞을 때
                return "wrong";
            }
        }
    }

    public MemberDTO findById(String id) {
        Member member = memberRepository.findById(id).orElse(null);
        return MemberDTO.fromEntity(member);
    }

    public List<MemberDTO> findAll() {
        return memberRepository.searchAll().stream().map(entity -> MemberDTO.fromEntity(entity)).toList();
    }

    public void certifyStatus(Long no) {
        Member member = memberRepository.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다."));
        member.setStatus(true);  // status 값을 true로 변경
        memberRepository.save(member);  // 변경된 회원 정보 저장
    }

    public MemberDTO findByNo(Long no) {
        Member member = memberRepository.findById(no).get();
        return MemberDTO.fromEntity(member);
    }

    public MemberDTO updateMember(MemberDTO dto) {
        Member member = MemberDTO.fromDTO(dto);
        return MemberDTO.fromEntity(memberRepository.save(member));
    }

    public void deleteStatus(Long no) {
        Member member = memberRepository.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다."));
        member.setStatus(false);  // status 값을 false로 변경
        memberRepository.save(member);  // 변경된 회원 정보 저장
    }
}

