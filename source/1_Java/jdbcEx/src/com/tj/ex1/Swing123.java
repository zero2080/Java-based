package com.tj.ex1;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Swing123 extends JFrame implements ActionListener{
	// GUI ���� ����
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtName, txtKor, txtEng, txtMat;
	private Vector<String> items;
	private JComboBox<String> comJob;
	private ImageIcon icon1, icon2;
	private JButton btnInput, btnSearch, btnOutput, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	// JDBC ���� ����
	private String            driver;
	private String            url;
	private Connection        conn;
	private PreparedStatement pstmt;
	private Statement         stmt;
	private ResultSet         rs;
	private ArrayList<PersonDto> person;
	
	public Swing123(String title) {
		driver= "oracle.jdbc.driver.OracleDriver";
		url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		person = new ArrayList<PersonDto>();
		// GUI �۾�
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x��ư Ŭ�� �� ����		
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel();
		jpup.setLayout(new GridLayout(5, 2));
		jpbtn = new JPanel();
		txtName = new JTextField(20);
		//items <- SELECT JNAME FROM JOB; 
		items = new Vector<String>();
		items.add("");
		try {
			Class.forName(driver); // 1�ܰ�
			conn = DriverManager.getConnection(url, "scott", "tiger"); //2�ܰ�
			stmt = conn.createStatement(); // 3�ܰ�
			rs = stmt.executeQuery("SELECT JNAME FROM JOB"); // 4+5�ܰ�
			while(rs.next()) {  // 6�ܰ�
				items.add(rs.getString("jname"));
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e) { }
		} // items�� DB ��������� ����
		comJob = new JComboBox<String>(items);
		txtKor = new JTextField(20);
		txtEng = new JTextField(20);
		txtMat = new JTextField(20);
		icon1 = new ImageIcon("src/com/tj/ex1/write.gif");
		btnInput = new JButton("�Է�", icon1);
		icon2 = new ImageIcon("src/com/tj/ex1/hot.gif");
		btnSearch = new JButton("������ȸ", icon2);
		btnOutput = new JButton("��ü���");
		btnExit   = new JButton("����");
		txtPool = new JTextArea(7, 40);
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comJob);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtKor);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtEng);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtMat);
		jpbtn.add(btnInput); jpbtn.add(btnSearch); 
		jpbtn.add(btnOutput); jpbtn.add(btnExit);
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		
		setSize(new Dimension(600, 400));
		setLocation(400, 300);
		setVisible(true);
		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnInput) { // �Է�(txtName, comJob, txtKor, txtEng, txtMat) 
			String sql1 = "INSERT INTO PERSON " + 
			" VALUES (PERSON_SEQ.NEXTVAL,?,(SELECT JNO FROM JOB WHERE JNAME=?),?,?,?)";
			//String sql1 = "INSERT INTO PERSON  " + 
			//		"    VALUES (PERSON_SEQ.NEXTVAL, ?, ?,?,?,?)";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, txtName.getText());
				pstmt.setString(2, comJob.getSelectedItem().toString());
				//pstmt.setInt(2, comJob.getSelectedIndex()*10);
				pstmt.setInt(3, Integer.parseInt(txtKor.getText()));
				pstmt.setString(4, txtEng.getText());
				pstmt.setInt(5, Integer.parseInt(txtMat.getText()));
				int result = pstmt.executeUpdate();
				System.out.println(result>0? "�Է¼���":"�Է½���");
				txtPool.setText(result>0? "�Է¼���":"�Է½���");
				txtPool.append(txtName.getText()+"�Է� ����");
				txtName.setText("");
				comJob.setSelectedIndex(0);
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if(pstmt!=null) pstmt.close();
					if(conn !=null) conn.close();
				} catch (Exception e1) {}
			}
			
		}else if(e.getSource()==btnSearch) {//��������ȸ(comJob)
			String sql2 = "SELECT ROWNUM RANK, NAMEID, JNAME, KOR, ENG, MAT, SUM " + 
				" FROM (SELECT NAME||'('||ID||')' NAMEID, JNAME, "
					+ "	KOR, ENG, MAT, KOR+ENG+MAT SUM " + 
				 "  FROM PERSON P, JOB J " + 
				 " WHERE P.JNO=J.JNO AND JNAME=? ORDER BY SUM DESC)";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, comJob.getSelectedItem().toString());
				rs = pstmt.executeQuery();
				person.clear();
				while(rs.next()) {
					int rank     = rs.getInt("rank");
					String nameid= rs.getString("nameid");
					String jname = rs.getString("jname");
					int kor = rs.getInt("kor");
					int eng = rs.getInt("eng");
					int mat = rs.getInt("mat");
					int sum = rs.getInt("sum");
					person.add(new PersonDto(rank, nameid, jname, kor, eng, mat, sum));
				}
				String temp = "���\t�̸�(ID)\t������\t����\t����\t����\t����\n";
				if(person.isEmpty()) {
					temp += "�ش� �������� �������� �����ϴ�";
				}else {
					for(PersonDto p : person) {
						temp += p.toString() +"\n";
					}
				}
				txtPool.setText(temp);
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if(rs  !=null)  rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn !=null) conn.close();
				} catch (Exception e1) { }
			}
		}else if(e.getSource()==btnOutput) {//��ü��ȸ
			String sql3 = "SELECT ROWNUM RANK, NAMEID, JNAME, KOR, ENG, MAT, SUM " + 
					 " FROM (SELECT NAME||'('||ID||')' NAMEID, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM " + 
					 "  FROM PERSON P, JOB J " + 
					 " WHERE P.JNO=J.JNO ORDER BY SUM DESC)";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql3);
				rs = pstmt.executeQuery();
				person.clear();
				while(rs.next()) {
					int rank     = rs.getInt("rank");
					String nameid= rs.getString("nameid");
					String jname = rs.getString("jname");
					int kor = rs.getInt("kor");
					int eng = rs.getInt("eng");
					int mat = rs.getInt("mat");
					int sum = rs.getInt("sum");
					person.add(new PersonDto(rank, nameid, jname, kor, eng, mat, sum));
				}
				txtPool.setText("���\t�̸�(ID)\t������\t����\t����\t����\t����\n");
				if(person.size()> 0) {
					for(int i=0 ; i<person.size() ; i++) {
						txtPool.append(person.get(i).toString() + "\n");
					}
				}else {
					txtPool.append("�������� �����ϴ�");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					if(rs  !=null)  rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn !=null) conn.close();
				} catch (Exception e1) { }
			}
		}else if(e.getSource()==btnExit) {
			setVisible(false); dispose(); System.exit(0);
		}
	}
}