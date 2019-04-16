package com.tj.ex2;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class StudentMng extends JFrame implements ActionListener {
	// GUI ������Ʈ ����
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtNo, txtName, txtScore;
	private Vector<String> jobs;
	private JComboBox<String> comMajor;
	private JButton btnNoSearch, btnNameSearch, btnMajorSearch;
	private JButton btnInput, btnUpdate, btnStudentOut;
	private JButton btnExpel, btnExit, btnExpelOut;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	// JDBC ���ú���
	private String driver;
	private String url;
	private Connection        conn;
	private PreparedStatement pstmt;
	private ResultSet         rs;
	private ArrayList<StudentDto> students;
	public StudentMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		students = new ArrayList<StudentDto>();
		driver= "oracle.jdbc.driver.OracleDriver";
		url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4,3));
		jpbtn = new JPanel();
		txtNo = new JTextField(10);
		txtName = new JTextField(10);
		jobs = new Vector<String>();
		jobs.add("");
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement("SELECT MNAME FROM MAJOR");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jobs.add(rs.getString("mname"));
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs  !=null)  rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			} catch (SQLException e1) { }
		}
		comMajor = new JComboBox<String>(jobs);
		txtScore = new JTextField(10);
		btnNoSearch = new JButton("�й��˻�");
		btnNameSearch = new JButton("�̸��˻�");
		btnMajorSearch = new JButton("�����˻�");
		btnInput = new JButton("�л��Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentOut = new JButton("�л����");
		btnExpel = new JButton("����ó��");
		btnExit = new JButton("����");
		btnExpelOut = new JButton("���������");
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("�й�", (int) CENTER_ALIGNMENT));
		jpup.add(txtNo);
		jpup.add(btnNoSearch);
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(btnNameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comMajor);
		jpup.add(btnMajorSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtScore);
		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExit);
		jpbtn.add(btnExpelOut);
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(600, 400));
		setLocation(200,150);
		setVisible(true);
		btnNoSearch.addActionListener(this);
		btnNameSearch.addActionListener(this);
		btnMajorSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);
		btnExpelOut.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNoSearch) {//�й��˻�
			String sql = "SELECT S.*, mNAME FROM STUDENT S, MAJOR M "
					+ "WHERE S.MNO=M.MNO AND sNO=?";
			String sno = txtNo.getText().trim();
			if(!sno.equals("")) {
				// �й� �Է������� �й� �˻� ����(conn, pstmt, rs ... close)
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sno);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						txtNo.setText(rs.getString("sno"));
						txtName.setText(rs.getString("sname"));
						comMajor.setSelectedItem(rs.getString("mname"));
						txtScore.setText(String.valueOf(rs.getInt("score")));
						//txtScore.setText(rs.getString("score"));
						txtPool.setText(sno+"�˻� �Ϸ�");
					}else {
						txtPool.setText("���� �й��Դϴ�");
						txtName.setText("");
						comMajor.setSelectedIndex(0);
						txtScore.setText("");
					}					
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if(rs   !=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn !=null) conn.close();
					} catch (SQLException e1) { }
				}
			}else {
				txtPool.setText("�й��� �Է� �� �й� �˻��ϼ���");
			}
		}else if(e.getSource()==btnNameSearch){ // �̸��˻�
			String sql = "SELECT S.*, mNAME FROM STUDENT S, MAJOR M "
					+ "WHERE S.MNO=M.MNO AND sNAME=?";
			String sname = txtName.getText().trim();
			if(sname.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sname);
					rs =  pstmt.executeQuery();
					students.clear();
					while(rs.next()) {
						String sno = rs.getString("sno");
						int mno = rs.getInt("mno");
						String mname = rs.getString("mname");
						int score = rs.getInt("score");
						int sexpel = rs.getInt("sexpel");
						txtNo.setText(sno);
						txtName.setText(sname);
						comMajor.setSelectedItem(mname);
						txtScore.setText(String.valueOf(score));
						students.add(new StudentDto(sno, sname, mno, score, sexpel, mname));
					}
					String temp = "\t�й�\t�̸�\t�а���\t����\t��������\n";
					temp += "����������������������������������������������������������������������������������������\n";
					if(students.size()==0) {
						temp += "\t �ش� �̸��� �л��� �����ϴ�";
					}else if(students.size()>1){
						for(StudentDto s : students) {
							temp += s.toString();
						}
					}					
					txtPool.setText(temp);
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if(rs   != null) rs.close();
						if(pstmt!= null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e1) {System.out.println(e1.getMessage());}
				}
			}else {
				txtPool.setText("�̸��� �Է��ϰ� �˻��ؾ���");
			}
		}else if(e.getSource()==btnMajorSearch) { //�����˻�
			String sql = "SELECT S.*, mNAME FROM STUDENT S, MAJOR M "
					+ "WHERE S.MNO=M.MNO AND MNAME=?";
			if(comMajor.getSelectedIndex()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, comMajor.getSelectedItem().toString());
					rs = pstmt.executeQuery();
					students.clear();
					while(rs.next()) {
						String sno = rs.getString("sno");
						String sname = rs.getString("sname");
						int mno      = rs.getInt("mno");
						String mname = rs.getString("mname");
						int score = rs.getInt("score");
						int sexpel = rs.getInt("sexpel");
						students.add(new StudentDto(sno, sname, mno, score, sexpel, mname));
					}
					String temp = "\t�й�\t�̸�\t�а���\t����\t��������\n";
					temp += "����������������������������������������������������������������������������������������\n";
					if(students.size()!=0) {
						for(StudentDto s : students) {
							temp += s.toString();
						}
					}else {
						temp += "\t �ش� �л��� �����ϴ�";
					}					
					txtPool.setText(temp);
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if(rs   != null) rs.close();
						if(pstmt!= null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e1) {System.out.println(e1.getMessage());}
				}
			}else {
				txtPool.setText("������ �����ϰ� �˻��ؾ���");
			}
		}else if(e.getSource()==btnInput){ // �л��Է�
			String sql = "INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES " + 
					"    (?,?, (SELECT mNO FROM MAJOR WHERE mNAME=?),?)";
			String sno = txtNo.getText().trim();
			String sname = txtName.getText().trim();
			if(sno.length()!=0 && sname.length()!=0 && comMajor.getSelectedIndex()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sno);
					pstmt.setString(2, sname);
					pstmt.setString(3, comMajor.getSelectedItem().toString());
					int score = 0;
					try {
						score = Integer.parseInt(txtScore.getText());
						if(score<0 || score>100) {
							System.out.println("��ȿ�� ������ �ƴϸ� 0��ó��");
							score = 0;
						}
					}catch (Exception e1) {
						System.out.println("�Է¾��ϰų� ���ڸ� 0��");
					}
					pstmt.setInt(4, score);
					int result = pstmt.executeUpdate();
					System.out.println(result>0? "�л��Է¼���":"�л��Է½���");
					txtPool.setText(result>0? "�л��Է¼���":"�л��Է½���");
					txtNo.setText("");
					txtName.setText("");
					comMajor.setSelectedIndex(0);
					txtScore.setText("");
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if(pstmt!= null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e1) {System.out.println(e1.getMessage());}
				}
			}else {
				txtPool.setText("�л��Է½� �й�, �̸�, ������ �Է��ؾ���");
			}
		}else if(e.getSource()==btnUpdate) { //�л�����
			String sql = "UPDATE STUDENT SET sNAME=?, " +
					 " mNO=(SELECT mNO FROM MAJOR WHERE mNAME=?), " + 
					 " SCORE=? " + 
					 " WHERE sNO=?";
			String sno = txtNo.getText().trim();
			String sname = txtName.getText().trim();
			if(sno.length()!=0 && sname.length()!=0 && comMajor.getSelectedIndex() !=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sname);
					pstmt.setString(2, comMajor.getSelectedItem().toString());
					int score = 0;
					try {
						score = Integer.parseInt(txtScore.getText());
						if(score<0 || score>100) {
							System.out.println("��ȿ�� ������ �ƴϸ� 0��ó��");
							score = 0;
						}
					}catch (Exception e1) {
						System.out.println("�Է¾��ϰų� ���ڸ� 0��");
					}
					pstmt.setInt(3, score);
					pstmt.setString(4, sno);
					int result = pstmt.executeUpdate();
					System.out.println(result>0? "�л���������":"�л���������");
					txtPool.setText(result>0? "�л���������":"�л���������");
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if(pstmt!= null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e1) {System.out.println(e1.getMessage());}
				}
			}else {
				txtPool.setText("�л������� �й�, �̸�, ������ �Է��ؾ���");
			}
		}else if(e.getSource()==btnStudentOut){ // �л����
			String sql = "SELECT S.*, mNAME FROM STUDENT S, MAJOR M "
					+ "WHERE S.mNO=M.mNO AND sEXPEL=0";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				students.clear();
				while(rs.next()) {
					StudentDto student = new StudentDto();
					student.setsNo(rs.getString("sno"));
					student.setsName(rs.getString("sname"));
					student.setmNo(rs.getInt("mno"));
					student.setScore(rs.getInt("score"));
					int sexpel = rs.getInt("sexpel");
					student.setsExpel(sexpel==0? "�л�":"������");
					student.setmName(rs.getString("mname"));
					students.add(student);
				}
				/*while(rs.next()) {
					String sNo   = rs.getString("sno");
					String sName = rs.getString("sname");
					int mNo      = rs.getInt("mno");;
					int score    = rs.getInt("score");;
					int sExpel   = rs.getInt("sexpel");
					String mName = rs.getString("mname");
					students.add(new StudentDto(sNo, sName, mNo, score, sExpel, mName));
				}*/
				txtPool.setText("\t�й�\t�̸�\t�а���\t����\t��������\n");
				txtPool.append("����������������������������������������������������������������������������������������\n");
				if(!students.isEmpty()) {
					for(StudentDto s : students) {
						txtPool.append(s.toString());
					}
				}else {
					txtPool.append("\t �ش� �л��� �����ϴ�");
				}					
				txtNo.setText("");
				txtName.setText("");
				comMajor.setSelectedIndex(0);
				txtScore.setText("");
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}finally {
				try {
					if(rs   != null) rs.close();
					if(pstmt!= null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e1) {System.out.println(e1.getMessage());}
			}
		}else if(e.getSource()==btnExpel) { // ����ó��
			String sql = "UPDATE STUDENT SET sEXPEL=1 WHERE sNO=?";
			String sno = txtNo.getText().trim();
			if(sno.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sno);
					int result = pstmt.executeUpdate();
					if(result>0) {
						System.out.println("����ó�� ����");
						txtPool.setText("����ó�� ����");
					}else {
						System.out.println("�ش� �й��� ���� ����ó�� �Ұ�");
						txtPool.setText("�ش� �й��� ���� ����ó�� �Ұ�");
					}
					txtNo.setText("");
					txtName.setText("");
					comMajor.setSelectedIndex(0);
					txtScore.setText("");
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if(pstmt!= null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e1) {System.out.println(e1.getMessage());}
				}
			}else {
				txtPool.setText("�й��� �Է��ϰ� ����ó���ؾ���");
			}
		}else if(e.getSource()==btnExit){ // ����
			setVisible(false);
			dispose();
			System.exit(0);
		}else if(e.getSource()==btnExpelOut) { //������ ���
			String sql = "SELECT S.*, mNAME FROM STUDENT S, MAJOR M "
					+ "WHERE S.mNO=M.mNO AND sEXPEL=1";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				students.clear();
				while(rs.next()) {
					String sNo   = rs.getString("sno");
					String sName = rs.getString("sname");
					int mNo      = rs.getInt("mno");;
					int score    = rs.getInt("score");;
					int sExpel   = rs.getInt("sexpel");
					String mName = rs.getString("mname");
					students.add(new StudentDto(sNo, sName, mNo, score, sExpel, mName));
				}				
				txtPool.setText("\t�й�\t�̸�\t�а���\t����\t��������\n");
				txtPool.append("����������������������������������������������������������������������������������������\n");
				if(!students.isEmpty()) {
					for(StudentDto s : students) {
						txtPool.append(s.toString());
					}
				}else {
					txtPool.append("\t �ش� �л��� �����ϴ�");
				}					
				txtNo.setText("");
				txtName.setText("");
				comMajor.setSelectedIndex(0);
				txtScore.setText("");
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}finally {
				try {
					if(rs   != null) rs.close();
					if(pstmt!= null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e1) {System.out.println(e1.getMessage());}
			}
		}
	}
	public static void main(String[] args) {
		new StudentMng("�л�����");
	}
}
