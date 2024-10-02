package com.my.QuizApplication.service;

import com.my.QuizApplication.dto.MemberDTO;
import com.my.QuizApplication.entity.Member;
import com.my.QuizApplication.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberDTO findByMemberId(String id){
        Optional<Member> findMember = memberRepository.findByMemberId(id);
        if(ObjectUtils.isEmpty(findMember)) return null;
        else{
            return MemberDTO.fromEntity(findMember.get());
        }
    }

    public boolean insertMember(MemberDTO newDto) {
        Optional<Member> findMember = memberRepository.findByMemberId(newDto.getMemberId());
        if (ObjectUtils.isEmpty(findMember)){
            if (newDto.getMemberId().equals("root") && newDto.getPassword().equals("admin")) {
                newDto.setStatus(true);
            }
            memberRepository.save(MemberDTO.fromDTO(newDto));
            return true;
        }else return false;
    }

    public void updateMember(MemberDTO updateDto) {
       memberRepository.save(MemberDTO.fromDTO(updateDto));
    }

    public List<MemberDTO> findAll(){
        return memberRepository.findAll().stream().map(member -> MemberDTO.fromEntity(member)).toList();
    }

    public void authenticate(Long no) {
        MemberDTO dto = MemberDTO.fromEntity(memberRepository.findById(no).get());
        dto.setStatus(true);
        memberRepository.save(MemberDTO.fromDTO(dto));
    }

    public MemberDTO findByNo(Long no) {
        return MemberDTO.fromEntity(memberRepository.findById(no).get());
    }

    public void deleteByNo(Long no) {
        memberRepository.deleteById(no);
    }
}
