package service;

import java.util.List;

import dto.ArticleDTO;
import entity.Article;
import repository.ArticleRepository;

public class ArticleService implements ServiceInterface{
	
	ArticleRepository articleRepository = new ArticleRepository();
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return 0;
	}

}
