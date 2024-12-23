package repository;

import db.DBConn;
import dto.TelBookDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookRepository implements RepositoryInterface{

    int result = 0; // 쿼리실행 결과를 담을 변수(성공 : 양수, 실패 : 0)
    Connection dbConn = DBConn.getConnection();
    PreparedStatement psmt = null;
    String sql;

    @Override
    public int insertData(TelBookDTO dto) {
        System.out.println("[PhoneBookRepository]-insertData");
        // DB에 저장하기
        try {
            sql = "INSERT INTO phone_book (name, age, address, phone, created_at) ";
            sql = sql + "VALUES (?, ?, ?, ?, ?)";
            psmt = dbConn.prepareStatement(sql);
            // 전달할 인자값을 psmt 에 추가
            psmt.setString(1, dto.getName());
            psmt.setInt(2, dto.getAge());
            psmt.setString(3, dto.getAddress());
            psmt.setString(4, dto.getPhone());
            psmt.setTimestamp(5, Timestamp.valueOf(dto.getCreatedAt()));

            // DB 에 저장 요청
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateData(TelBookDTO dto) {
        System.out.println("[PhoneBookRepository]-updateData");
        // 수정작업 처리
        sql = "UPDATE phone_book SET ";
        sql = sql + "name = ?, ";
        sql = sql + "age = ?, ";
        sql = sql + "address = ?, ";
        sql = sql + "phone = ?, ";
        sql = sql + "created_at = ?, ";
        sql = sql + "updated_at = ? ";
        sql = sql + "WHERE id = ?";
        return 0;
    }

    @Override
    public int deleteData(Long id) {
        System.out.println("[PhoneBookRepository]-deleteData");
        sql = "DELETE FROM phone_book WHERE id=?";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setLong(1, id);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<TelBookDTO> getAllList() {
        System.out.println("[PhoneBookRepository]-getAllList");
        List<TelBookDTO> dtoList = new ArrayList<>();

        ResultSet rs = null;

        try {
            sql = "SELECT * FROM phone_book ORDER BY id ASC";
            psmt = dbConn.prepareStatement(sql);
            // 쿼리 실행할 결과 -> ResultSet
            rs = psmt.executeQuery();

            // ResultSet의 내용을 하나씩 읽어서 dtoList 에 담는다.
            while (rs.next()) {
                // ResultSet에 있는 레코드를 하나씩 읽어서 담을 DTO
                TelBookDTO dto = new TelBookDTO();
                // 레코드를 하나씩 읽어서 DTO에 담는 작업
                dto.setId(rs.getLong("id"));
                dto.setName(rs.getString("name"));
                dto.setAge(rs.getInt("age"));
                dto.setPhone(rs.getString("phone"));
                dto.setAddress(rs.getString("address"));
                dto.setCreatedAt(rs.getTimestamp("created_at")
                        .toLocalDateTime());
                if (rs.getTimestamp("updated_at") != null) {
                    dto.setUpdateAt(rs.getTimestamp("updated_at")
                            .toLocalDateTime());
                }
                // 담은 DTO를 리스트에 담는다.
                dtoList.add(dto);
            }
            // ResultSet 닫기
            rs.close();
            // PreparedStatement 닫기
            psmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoList;
    }

    @Override
    public TelBookDTO findById(Long id) {
        System.out.println("[PhoneBookRepository]-findById");
        TelBookDTO dto = new TelBookDTO();
        ResultSet rs = null;

        sql = "SELECT * FROM phone_book WHERE id = ?";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setLong(1, id);
            rs = psmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    dto.setId(rs.getLong("id"));
                    dto.setName(rs.getString("name"));
                    dto.setAge(rs.getInt("age"));
                    dto.setAddress(rs.getString("address"));
                    dto.setPhone(rs.getString("phone"));
                    dto.setCreatedAt(rs.getTimestamp("created_at")
                            .toLocalDateTime());
                    if (rs.getTimestamp("updated_at") != null) {
                        dto.setUpdateAt(rs.getTimestamp("updated_at")
                                .toLocalDateTime());
                    }
                }
            }
            return dto;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TelBookDTO> findByName(String name) {
        System.out.println("[PhoneBookRepository]-findByName");
        return List.of();
    }

    @Override
    public List<TelBookDTO> findByPhone(String phone) {
        System.out.println("[PhoneBookRepository]-findByPhone");
        return List.of();
    }
}
