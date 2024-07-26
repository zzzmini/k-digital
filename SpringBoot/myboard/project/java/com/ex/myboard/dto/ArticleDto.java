package com.ex.myboard.dto;

import com.ex.myboard.entity.Article;
import com.ex.myboard.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String title;
    private String content;
    private List<Comment> commentList;

    public static Article fromArticleDto(ArticleDto dto) {
        Article article = new Article();
        article.setId(dto.id);
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        return article;
    }

    public static ArticleDto fromArticle(Article article) {
        return new ArticleDto(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getCommentList());
    }
}
