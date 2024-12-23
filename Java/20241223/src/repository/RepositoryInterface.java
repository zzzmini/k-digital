package repository;

import dto.TelBookDTO;

import java.util.List;

public interface RepositoryInterface {
    int insertData(TelBookDTO dto);

    int updateData(TelBookDTO dto);

    int deleteData(Long id);

    // 전체 데이터 읽어오기
    List<TelBookDTO> getAllList();

    // ID로 검색
    TelBookDTO findById(Long id);

    // 이름으로 검색
    List<TelBookDTO> findByName(String name);

    // 전화번호로 검색
    List<TelBookDTO> findByPhone(String phone);
}
