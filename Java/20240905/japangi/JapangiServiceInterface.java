package japangi;

import java.util.List;

public interface JapangiServiceInterface {
	// 검색어로 검색하기
	List<Product> searchKeyword();
	// 새로운 상품 등록(제품 클래스를 받아서 추가)
	void newProduct(Product product);
	// 삭제(상품명을 받아서 삭제)
	void deleteProduct(String name);
	// 수정(제품 클래스 받아서 수정)
	void updateProduct(Product product);
	// 전체조회
	List<Product> selectAll();
	// 단건 조회
	List<Product> selectOne();
}
