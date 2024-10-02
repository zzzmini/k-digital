package com.ex.OXQuiz.service;

import com.ex.OXQuiz.dto.MemberDTO;
import com.ex.OXQuiz.entity.Member;
import com.ex.OXQuiz.repository.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public void insertUser(@Valid MemberDTO dto) {
        //memberId가 root이면 status 값을 1로 설정해주기
        if ("root".equals(dto.getMemberId()) & "admin".equals(dto.getMemberPassword())) {
            dto.setStatus(true);
        }else{
            dto.setStatus(false);
        }
        userRepository.save(MemberDTO.fromDTO(dto));
    }

    public List<MemberDTO> findAll() {
        return userRepository.findAll().stream().map(x->MemberDTO.fromEntity(x)).toList();
    }

    public MemberDTO findByMemberId(MemberDTO dto) {
        Member member = userRepository.findByMemberId(dto.getMemberId()).orElse(null);
        log.info("### service member : " + member);

        // 아이디 확인
        if (ObjectUtils.isEmpty(member)) {
            return null;
        }

        // 비밀번호 확인
        if (dto.getMemberPassword().equals(member.getMemberPassword())) {
            log.info("### service member dto : " + MemberDTO.fromEntity(member));
            return MemberDTO.fromEntity(member);
        } else {
            log.warn("password mismatch for ID : " + dto.getMemberId());
            member.setMemberPassword(null);
            return MemberDTO.fromEntity(member);
        }
    }

    public List<MemberDTO> findAllUsers() {
        return userRepository.findAllUsers().stream().map(x->MemberDTO.fromEntity(x)).toList();
    }

    public MemberDTO findById(Long id) {
        return MemberDTO.fromEntity(userRepository.findById(id).get());
    }

    public MemberDTO updateUser(MemberDTO dto) {
        return MemberDTO.fromEntity(userRepository.save(MemberDTO.fromDTO(dto)));
    }

    public MemberDTO findByLoginId(String myId) {
        return MemberDTO.fromEntity(userRepository.findByMemberId(myId).get());
    }

    public boolean memberIdExists(String memberId) {
        return userRepository.findByMemberId(memberId).isPresent();
    }
}
