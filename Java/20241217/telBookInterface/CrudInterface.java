package telBookInterface;

import dto.TelBookDto;

import java.util.List;

public interface CrudInterface {
    TelBookDto findById(int updateId);
    List<TelBookDto> searchName(String searchName);
    // 입력
    int insert(TelBookDto telBook);
    // 수정
    int update(TelBookDto telBook);
    // 삭제
    int delete(Integer id);
    // 전체검색
    List<TelBookDto> getListAll();
    // 단일자료 검색
    TelBookDto getOne(String name);
}
