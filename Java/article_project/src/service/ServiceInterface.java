package service;

import java.util.List;

import dto.ArticleDTO;
import entity.Article;

public interface ServiceInterface {
	// 전체 글 가져오기
	List<ArticleDTO> findAll();
	
	// 새글 작성하기
	int newArticle(ArticleDTO dto);
	
	// 글 상세 보기
	Article findById(Long id);
	
	// 게시글 삭제
	int delete(Long id);
	
	// 게시글 수정
	int update(Article article);
}
