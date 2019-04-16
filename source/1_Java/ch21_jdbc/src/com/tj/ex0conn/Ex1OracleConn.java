package com.tj.ex0conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Ex1OracleConn {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		try {
			Class.forName(driver);// �� ����̹��ε�
			System.out.println("����̹� �ε� ����");
			conn = DriverManager.getConnection(url, "scott", "tiger");
					// �� ���� ��ü ����
			System.out.println("���� ��ü ������ ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ���� :"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("���� ���� : "+e.getMessage());
		}finally {
			try {
				if(conn!=null) conn.close(); // �� ��������
			}catch (Exception e) { }
		}

	}
}
