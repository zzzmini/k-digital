package telBookApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import telBookApp.db.DBConn;
import telBookApp.entity.TelBook;

public class TelBookDAO implements CrudInterface {

	@Override
	public int insert(TelBook telBook) {
		// 결과를 돌려줄 변수

		int result = 0;

//		System.out.println("DAO insert");
		// 전달된 telBook DB에 저장

		Connection conn = DBConn.getConnection();
		// 쿼리 실어보낼 아이
		PreparedStatement psmt = null;
		// 쿼리 작성
		String sql;

		sql = "INSERT INTO telbook(name, age, address, phone) " + " VALUES (?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, telBook.getName());
			psmt.setInt(2, telBook.getAge());
			psmt.setString(3, telBook.getAddress());
			psmt.setString(4, telBook.getPhone());

			result = psmt.executeUpdate();
			psmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(result);
		return result;
	}

	@Override
	public int update(TelBook telBook) {
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;
		String sql = "UPDATE telbook " + 
				"SET name = ?, " +
				"age = ?, " +
				"address = ?, " +
				"phone = ? " +
				"WHERE id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, telBook.getName());
			psmt.setInt(2, telBook.getAge());
			psmt.setString(3, telBook.getAddress());
			psmt.setString(4, telBook.getPhone());
			psmt.setLong(5, telBook.getId());
			
			result =  psmt.executeUpdate();
			psmt.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}

	@Override
	public int delete(Long id) {
//		System.out.println("DAO delete");
		int result = 0;

		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;
		String sql = "DELETE FROM telbook WHERE id = ?";

		try {
			psmt = conn.prepareCall(sql);
			psmt.setLong(1, id);

			result = psmt.executeUpdate();
			psmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	@Override
	public List<TelBook> getListAll() {
//		System.out.println("DAO getListAll");

		// RecordSet을 하나씩 읽어서 담을 TelBook entity 리스트 선언
		List<TelBook> telBooks = new ArrayList<TelBook>();

		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM telbook ORDER BY name";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				TelBook book = new TelBook();
				book.setId(rs.getLong("id"));
				book.setName(rs.getString("name"));
				book.setAge(rs.getInt("age"));
				book.setAddress(rs.getString("address"));
				book.setPhone(rs.getString("phone"));
				telBooks.add(book);
			}
			rs.close();
			psmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return telBooks;
	}

	@Override
	public TelBook getOne(Long id) {
//		System.out.println("DAO getOne");

		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM telbook WHERE id = ?";
		TelBook book = null;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, id);

			rs = psmt.executeQuery();
			// 갖고온 데이터를 TelBook에 담아서 리턴
			while (rs.next()) {
				book = new TelBook();
				book.setId(rs.getLong("id"));
				book.setName(rs.getString("name"));
				book.setAge(rs.getInt("age"));
				book.setAddress(rs.getString("address"));
				book.setPhone(rs.getString("phone"));
			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return book;
	}

	@Override
	public List<TelBook> searchKeyword(int num, String keyword) {
		List<TelBook> results = new ArrayList<TelBook>();
		
		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "";

		switch (num) {
		case 2: // 이름 검색
			sql = "SELECT * FROM telbook WHERE name LIKE ?";
			break;
		case 3: // 주소검색
			sql = "SELECT * FROM telbook WHERE address LIKE ?";
			break;
		case 4: // 전화번호 검색
			sql = "SELECT * FROM telbook WHERE phone LIKE ?";
			break;
		}

		TelBook book = null;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + keyword + "%");

			rs = psmt.executeQuery();
			// 갖고온 데이터를 TelBook에 담아서 리턴
			while (rs.next()) {
				book = new TelBook();
				book.setId(rs.getLong("id"));
				book.setName(rs.getString("name"));
				book.setAge(rs.getInt("age"));
				book.setAddress(rs.getString("address"));
				book.setPhone(rs.getString("phone"));
				results.add(book);
			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return results;
	}

}
