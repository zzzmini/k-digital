package telBookApp.dao;

import java.util.List;

import telBookApp.entity.TelBook;

public interface CrudInterface {
	// 입력
	int insert(TelBook telBook);
	// 수정
	int update(TelBook telBook);
	// 삭제
	int delete(Long id);
	// 전체검색
	List<TelBook> getListAll();
	// 단일레코드 검색
	TelBook getOne(Long id);
	List<TelBook> searchKeyword(int num, String keyword);
}
