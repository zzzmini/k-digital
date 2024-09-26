package com.ex.basicCRUD.service;

import com.ex.basicCRUD.dto.MemberDTO;
import com.ex.basicCRUD.entity.Member;
import com.ex.basicCRUD.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<MemberDTO> findAll() {
        return memberRepository.findAll()
                .stream()
                .map(entity -> MemberDTO.fromEntity(entity))
                .toList();
    }
}
