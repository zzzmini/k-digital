package repository;

import java.util.ArrayList;
import java.util.List;

import crudInterface.CRUDInterface;
import entity.Article;

public class ArticleRepository implements CRUDInterface{
	// 게시글의 자동생성 아이디 역할
	public static Long articleId = 1L;
	// 게시글 저장소(테이블 역할)
	private List<Article> articles = new ArrayList<Article>();
	

	public List<Article> getArticles() {
		return articles;
	}

	@Override
	public List<Article> findAll() {
		return articles;
	}

	@Override
	public int insert(Article article) {
		articles.add(article);
		return 1;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateById(Article article) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Article findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
