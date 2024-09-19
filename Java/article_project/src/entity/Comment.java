package entity;

import java.time.LocalDateTime;

import common.CommonField;

public class Comment extends CommonField{
	private Long comment_id;
	private Long article_id ;
	private String c_name;
	private String c_content;
	
	public Comment() {}
	
	
	public Comment(Long comment_id, Long article_id, 
			String c_name, String c_content, LocalDateTime insertedDate,
			LocalDateTime updatedDate) {
		this.comment_id = comment_id;
		this.article_id = article_id;
		this.c_name = c_name;
		this.c_content = c_content;
		setInsertedDate(insertedDate);
		setUpdatedDate(updatedDate);
	}


	public Long getComment_id() {
		return comment_id;
	}
	public void setComment_id(Long comment_id) {
		this.comment_id = comment_id;
	}
	public Long getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Long article_id) {
		this.article_id = article_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	
	
}
