package dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import common.CommonField;
import entity.Article;
import entity.Comment;

public class ArticleDTO extends CommonField{
	private Long id;
	private String name;
	private String title;
	private String content;
	
	private List<CommentDTO> commentLists 
					= new ArrayList<CommentDTO>();
	
	
	public List<CommentDTO> getCommentLists() {
		return commentLists;
	}


	public void setCommentLists(List<CommentDTO> commentLists) {
		this.commentLists = commentLists;
	}


	// Entity를 받아서 DTO로 변환
	public static ArticleDTO fromEntity(Article article) {
		ArticleDTO dto = new ArticleDTO();
		dto.setId(article.getId());
		dto.setName(article.getName());
		dto.setTitle(article.getTitle());
		dto.setContent(article.getContent());
		dto.setInsertedDate(article.getInsertedDate());
		if(article.getUpdatedDate()!=null) {
			dto.setUpdatedDate(article.getUpdatedDate());
		} else {
			dto.setUpdatedDate(null);
		}
		
		dto.commentLists = article.getCommentLists()
										.stream()
										.map(x -> CommentDTO.fromComment(x))
										.toList();
		
		return dto;
	}
	
	
	// DTO를 Entity로 변환(새글의 경우)
	public static Article makeNewArticle(ArticleDTO dto) {
		Article article = new Article();
		article.setId(dto.getId());
		article.setName(dto.getName());
		article.setTitle(dto.getTitle());
		article.setContent(dto.getContent());
		if(dto.getInsertedDate() == null) {
			article.setInsertedDate(LocalDateTime.now());
		} else {
			article.setInsertedDate(dto.getInsertedDate());
		}
		
		if(dto.getUpdatedDate()!=null) {
			article.setUpdatedDate(dto.getUpdatedDate());
		} else {
			article.setUpdatedDate(null);
		}
	return article;
}
	
	// 입력받은 자료를 DTO로 변환
	public static ArticleDTO makeArticleDto
		(Long id, String name, String title, String content) {
		return new ArticleDTO(id, name, title, content);
	}
	
	
	public ArticleDTO() {}
	
	public ArticleDTO(Long id, String name, String title, String content) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + 
				", title=" + title + ", content=" + content + 
				", InsertDate=" + getInsertedDate() +  
				", UpdateDate=" + getUpdatedDate() + "]";
	}	
}
