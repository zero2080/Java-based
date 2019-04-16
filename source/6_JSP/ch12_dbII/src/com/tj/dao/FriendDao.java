package com.tj.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.tj.dto.FriendDto;
public class FriendDao {
	private DataSource dataSource;
	private static FriendDao instance = new FriendDao();
	public static FriendDao getInstance() {
		return instance;
	}
	private FriendDao() {
		Context context;
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}		
	}
	public int friendInsert(FriendDto dto) {
		int result = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FRIEND VALUES (FRIEND_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			result = pstmt.executeUpdate();
			System.out.println(result>0? "친구추가 성공":"친구추가 실패");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {}
		}
		return result;
	}
	public ArrayList<FriendDto> friendSelect(){
		ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
		Connection 		   conn = null;
		PreparedStatement  pstmt= null;
		ResultSet          rs   = null;
		String sql = "SELECT * FROM FRIEND";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs   = pstmt.executeQuery();
//			FriendDto dto = new FriendDto();
			while(rs.next()) {
				FriendDto dto = new FriendDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dtos.add(dto);
//				int    no   = rs.getInt("no");      
//				String name = rs.getString("name");
//				String phone = rs.getString("phone");
//				dtos.add(new FriendDto(no, name, phone));				
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null)  rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch (Exception e) { }
		}
		return dtos;
	}
	public ArrayList<FriendDto> friendSelect(String nameStr, String phoneStr){
		ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
		Connection 		   conn = null;
		PreparedStatement  pstmt= null;
		ResultSet          rs   = null;
		String sql = "SELECT * FROM FRIEND " + 
				"    WHERE NAME LIKE '%'||?||'%' AND PHONE LIKE '%'||?||'%'";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nameStr);
			pstmt.setString(2, phoneStr);
			rs   = pstmt.executeQuery();
			while(rs.next()) {
				int    no   = rs.getInt("no");      
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				dtos.add(new FriendDto(no, name, phone));
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null)  rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch (Exception e) { }
		}
		return dtos;
	}
}
