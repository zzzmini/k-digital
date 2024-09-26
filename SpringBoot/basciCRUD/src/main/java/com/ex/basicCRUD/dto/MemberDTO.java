package com.ex.basicCRUD.dto;

import com.ex.basicCRUD.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// POJO(Plain Old Java Object)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Long id;
    private String name;
    private int age;
    private String address;

    // Entity -> DTO
    public static MemberDTO fromEntity(Member member) {
        return new MemberDTO(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getAddress()
        );
    }

    // DTO -> Entity
    public static Member fromDTO(MemberDTO dto) {
        return new Member(
           dto.getId(),
           dto.getName(),
           dto.getAge(),
           dto.getAddress()
        );
    }
}
