package com.ex.myboard.service;

import com.ex.myboard.dto.ArticleDto;
import com.ex.myboard.entity.Article;
import com.ex.myboard.repository.ArticleRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    EntityManager em;

    @Autowired
    ArticleRepository articleRepository;
    public List<ArticleDto> findAll() {
        return articleRepository.findAll()
                .stream()
                .map(ArticleDto::fromArticle)
                .collect(Collectors.toList());
    }

    @Transactional
    public void createArticle(ArticleDto dto) {
        Article article = ArticleDto.fromArticleDto(dto);
        em.persist(article);
    }

    public ArticleDto getOneArticle(Long id) {
        Article article = em.find(Article.class, id);
        ArticleDto dto;
        dto = ArticleDto.fromArticle(article);
        System.out.println("==== " + dto);
        return dto;
    }

    @Transactional
    public void deleteArticle(Long id) {
        Article article = em.find(Article.class, id);
        em.remove(article);
    }

    @Transactional
    public void updateArticle(ArticleDto dto) {
        Article article = em.find(Article.class, dto.getId());
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
    }
}
