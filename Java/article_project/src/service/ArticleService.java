package service;

import java.util.List;

import crudInterface.CRUDInterface;
import dao.ArticleDAO;
import dto.ArticleDTO;
import entity.Article;

public class ArticleService implements ServiceInterface{
	
//	CRUDInterface articleRepository = new ArticleRepository();
	CRUDInterface articleRepository = new ArticleDAO();
	
	@Override
	public List<ArticleDTO> findAll() {
		List<Article> articleLists = articleRepository.findAll();
		
		return articleLists
				.stream()
				.map(x -> ArticleDTO.fromEntity(x))
				.toList();
	}

	@Override
	public int newArticle(ArticleDTO dto) {
		if(dto == null) {
			return -1;	
		} else {
			return articleRepository
					.insert(ArticleDTO.makeNewArticle(dto));
		}
	}

	@Override
	public Article findById(Long id) {
		return articleRepository.findById(id);
	}

	@Override
	public int delete(Long id) {
		return articleRepository.deleteById(id);
	}

	@Override
	public int update(Article article) {
		return articleRepository.updateById(article);
	}

}
