package repository;

import dto.SearchResultDTO;
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
    List<SearchResultDTO> findByName(String name);

    // 전화번호로 검색
    List<SearchResultDTO> findByPhone(String phone);
}
