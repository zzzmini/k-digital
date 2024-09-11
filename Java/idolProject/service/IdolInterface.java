package idol_project.service;

import idol_project.vo.Idol;

public interface IdolInterface {
	void insert(int insertKey, Idol idol);  //신규 입력처리
	void update(int updateKey, Idol idol);  // 기존 데이터 업데이트
	void delete(int deleteKey);  // 기존 데이터 삭제
	void selectAll();  // 기존 데이터 검색 후 출력
}
