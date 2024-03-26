package service;

import db.DBConn;
import dto.TelDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelBookService {

    //데이터 입력
    public int insertData(TelDto dto){
        int result = 0;
        Connection conn = DBConn.getConnection();
        PreparedStatement psmt = null;
        String sql;
        try {
            sql = "insert into telbook(name, age, addr, tel) " +
                    "values (?,?,?,?)";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1,dto.getName());
            psmt.setInt(2, dto.getAge());
            psmt.setString(3, dto.getAddress());
            psmt.setString(4,dto.getTelNum());

            result = psmt.executeUpdate();
            psmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    // 전체 데이터 가져오기
    public List<TelDto> getListAll(){
        List<TelDto> dtoList = new ArrayList<>();
        Connection conn = DBConn.getConnection();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql;
        try {
            sql = "select * from telbook order by name";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            while (rs.next()){
                dtoList.add(TelDto.allOf(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("addr"),
                        rs.getString("tel")
                ));
            }
            rs.close();
            psmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dtoList;
    }
}