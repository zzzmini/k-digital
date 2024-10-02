package com.ex.quizCRUD.service;

import com.ex.quizCRUD.dto.MemberDTO;
import com.ex.quizCRUD.entity.Member;
import com.ex.quizCRUD.repository.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<MemberDTO> findAll(){
        return memberRepository.findAll().stream().map(entity->MemberDTO.fromEntity(entity)).toList();
    }

    public Long saveMember(MemberDTO dto) {
        // 관리자 계정 회원가입 체크
        Member member = memberRepository.findUserId(dto.getId()).orElse(null);

        // id: root, pwd: admin 이면 관리자로 설정
        if(dto.getId().equals("root") && dto.getPassword().equals("admin")){
            dto.setStatus(true);
        }else{
            dto.setStatus(false);
        }

        if(ObjectUtils.isEmpty(member)){
            // 회원가입 상태가 아니므로
            memberRepository.save(MemberDTO.fromDTO(dto));
            return 1L;
        }else{
            if(member.getId().equals(dto.getId())){  // 이미 회원가입한 id
                return 0L;
            }else{
                memberRepository.save(MemberDTO.fromDTO(dto));
                return 1L;
            }
        }
    }

    public MemberDTO findById(MemberDTO dto) {
        log.info("service dto: " + dto.getId());
        Member member = memberRepository.findUserId(dto.getId()).orElse(null);
        if(ObjectUtils.isEmpty(member)){
            return null;
        }else{
            if(member.getPassword().equals(dto.getPassword())){
                return MemberDTO.fromEntity(member);
            }else{
                return null;
            }
        }
    }

    public void updateStatus(Long no, Boolean status) {
        log.info("memberService_no: " + no + ", status: " + status);
        if(status){  // 인증삭제
             memberRepository.updateStatus(no, false);
        }else {  // 인증하기
            memberRepository.updateStatus(no, true);
        }
    }

    public MemberDTO userInfo(String id) {
        Member member = memberRepository.findUserId(id).get();
        log.info(member.toString());
        if(ObjectUtils.isEmpty(member)){
            return null;
        }else {
            return MemberDTO.fromEntity(member);
        }
    }

    public void updateMember(MemberDTO dto) {
        memberRepository.save(MemberDTO.fromDTO(dto));
    }

    public void answerCount(String id, Boolean bl) {
        log.info("memberService_answer: " + id);
        if(bl){  // 정답이면 count
            memberRepository.rightAnswer(id);
        }else{  // 오답이면 count
             memberRepository.worngAnswer(id);
        }
    }
}
