package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		return 0;
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
