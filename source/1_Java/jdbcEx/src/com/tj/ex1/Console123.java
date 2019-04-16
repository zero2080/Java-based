package com.tj.ex1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
public class Console123 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String sql1 = "INSERT INTO PERSON "
		 +" VALUES (PERSON_SEQ.NEXTVAL,?,(SELECT JNO FROM JOB WHERE JNAME=?),?,?,?)";
		String sql2 = "SELECT ROWNUM RANK, NAMEID, JNAME, KOR, ENG, MAT, SUM " + 
		 " FROM (SELECT NAME||'('||ID||')' NAMEID, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM " + 
		 "  FROM PERSON P, JOB J " + 
		 " WHERE P.JNO=J.JNO AND JNAME=? ORDER BY SUM DESC)";
		String sql3 = "SELECT ROWNUM RANK, NAMEID, JNAME, KOR, ENG, MAT, SUM " + 
		 " FROM (SELECT NAME||'('||ID||')' NAMEID, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM " + 
		 "  FROM PERSON P, JOB J " + 
		 " WHERE P.JNO=J.JNO ORDER BY SUM DESC)";
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		Statement         stmt  = null;
		ResultSet         rs    = null;
		ArrayList<PersonDto> person = new ArrayList<PersonDto>();
		Scanner sc = new Scanner(System.in);
		String fn = "";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			do {
				System.out.print("원하는 번호는?(1:입력, 2:직업조회, 3:전체조회, 그외:종료)");
				fn = sc.next();
				switch (fn) {
				case "1": //입력(이름, 직업명, 국어, 영어, 수학)받아 -> insert (sql1)
					pstmt = conn.prepareStatement(sql1);//3단계부터
					System.out.print("입력할 이름은?");
					String name = sc.next();
					System.out.print("입력할 직업명은 ?");
					String jname = sc.next();
					System.out.print("국어는 ?");
					int kor = sc.nextInt();
					System.out.print("영어는 ?");
					int eng = sc.nextInt();
					System.out.print("수학은 ?");
					int mat = sc.nextInt();
					pstmt.setString(1, name);
					pstmt.setString(2, jname);
					pstmt.setInt(3, kor);
					pstmt.setInt(4, eng);
					pstmt.setInt(5, mat);
					int result = pstmt.executeUpdate();
					System.out.println(result>0? "입력 성공":"입력 실패");
					pstmt.close();
					break;
				case "2": //입력(직업명)받아 -> select (sql2) 전송후 결과 출력
					pstmt = conn.prepareStatement(sql2); // 3단계부터
					System.out.print("출력을 원하는 직업명은 ?");
					jname = sc.next();
					pstmt.setString(1, jname);
					rs = pstmt.executeQuery();
					person.clear(); // arraylist person을 데이터를 지우는 함수
					while(rs.next()) {
						int rank = rs.getInt("rank");
						String nameid = rs.getString("nameid");
						kor = rs.getInt("kor");
						eng = rs.getInt("eng");
						mat = rs.getInt("mat");
						int sum = rs.getInt("sum");
						person.add(new PersonDto(rank, nameid, jname, kor, eng, mat, sum));
					}
					System.out.println("등수\t이름(ID)\t직업\t국어\t영어\t수학\t총점");
					if(person.size()==0) {
						System.out.println("해당 직업군의 연예인이 없습니다");
					}else {
						for(PersonDto p : person) {
							System.out.println(p);
						}
					}
					rs.close();
					pstmt.close();
					break;
				case "3": // sql3전송후 결과 출력
					stmt = conn.createStatement();//3단계부터
					rs = stmt.executeQuery(sql3); 
					person.clear(); // arraylist person을 데이터를 지우는 함수
					while(rs.next()) {
						int rank = rs.getInt("rank");
						String nameid = rs.getString("nameid");
						jname = rs.getString("jname");
						kor = rs.getInt("kor");
						eng = rs.getInt("eng");
						mat = rs.getInt("mat");
						int sum = rs.getInt("sum");
						person.add(new PersonDto(rank, nameid, jname, kor, eng, mat, sum));
					}
					System.out.println("등수\t이름(ID)\t직업\t국어\t영어\t수학\t총점");
					if(person.size()==0) {
						System.out.println("연예인이 없습니다");
					}else {
						for(PersonDto p : person) {
							System.out.println(p);
						}
					}
					rs.close();
					stmt.close();
					break;
				}
			}while(fn.equals("1")||fn.equals("2")||fn.equals("3"));
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(stmt !=null) stmt.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null)  conn.close();
			} catch (Exception e) {}
		}
	}
}




















