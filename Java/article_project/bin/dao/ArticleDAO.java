package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import crudInterface.CRUDInterface;
import db.DBConn;
import entity.Article;

public class ArticleDAO implements CRUDInterface{

	@Override
	public List<Article> findAll() {
		List<Article> articles = new ArrayList<Article>();
		
		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM articles ORDER BY id DESC";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Article article = new Article();
				article.setId(rs.getLong("id"));
				article.setName(rs.getString("name"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				article.setInsertedDate(
						rs.getTimestamp("inserted_date").toLocalDateTime());
				if(rs.getTimestamp("updated_date") != null) {
					article.setUpdatedDate(rs.getTimestamp("updated_date")
							.toLocalDateTime());
				}else {
					article.setUpdatedDate(null);
				}
				articles.add(article);
			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return articles;
	}

	@Override
	public int insert(Article article) {
		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;
		
		String sql = "INSERT INTO articles (name, title, content, inserted_date) " +
				" VALUES(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, article.getName());
			psmt.setString(2, article.getTitle());
			psmt.setString(3, article.getContent());
			psmt.setTimestamp(4, Timestamp.valueOf(article.getInsertedDate()));
			
			return psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	@Override
	public int deleteById(Long id) {
		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;
		
		String sql = "DELETE FROM articles WHERE id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, id);
			return psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return 0;
	}

	@Override
	public int updateById(Article article) {
		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;
		
		String sql = "UPDATE articles SET " +
							"title = ?, content = ?, updated_date = ? WHERE id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, article.getTitle());
			psmt.setString(2, article.getContent());
			psmt.setTimestamp(3, Timestamp.valueOf(article.getUpdatedDate()));
			psmt.setLong(4, article.getId());
			
			return psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return 0;
	}

	@Override
	public Article findById(Long id) {
		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM articles WHERE id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, id);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Article article = new Article();
				article.setId(rs.getLong("id"));
				article.setName(rs.getString("name"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				article.setInsertedDate(rs
						.getTimestamp("inserted_date").toLocalDateTime());
				if(rs.getTimestamp("updated_date") != null) {
					article.setUpdatedDate(rs
				    		.getTimestamp("updated_date").toLocalDateTime());	
				} else {
					article.setUpdatedDate(null);
				}
			    
			    return article;
			}
			rs.close();
			psmt.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
