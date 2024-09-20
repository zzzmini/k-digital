package crudInterface;

import java.util.List;

import entity.Article;
import entity.Comment;

public interface CRUDInterface {
	// 전체보기
	List<Article> findAll();
	
	// 새글 작성
	int insert(Article article);
	// 삭제
	int deleteById(Long id);
	// 수정
	int updateById(Article article);
	// 상세보기
	Article findById(Long id);
	// 댓글 추가
	public void insertComment(Comment comment);
	// 댓글 수정
	public void updateComment(Comment comment);
	// 댓글 삭제
	public void deleteComment(Long commentId);
}
