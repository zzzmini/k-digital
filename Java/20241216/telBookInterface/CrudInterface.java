package telBookInterface;

import dto.TelBookDto;

import java.util.List;

public interface CrudInterface {
    // 입력
    int insert(TelBookDto telBook);
    // 수정
    int update(TelBookDto telBook);
    // 삭제
    int delete(Long id);
    // 전체검색
    List<TelBookDto> getListAll();
    // 단일자료 검색
    TelBookDto getOne(String name);
}
