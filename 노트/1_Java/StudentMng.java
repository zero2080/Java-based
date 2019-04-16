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
		btnMajorSearch = new JButton("�й��˻�");
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
		}else if(e.getSource()==btnNameSearch) {//�̸��˻�
			String sql = "SELECT S.*, mNAME FROM STUDENT S, MAJOR M "
					+ "WHERE S.MNO=M.MNO AND sNAME=?";
			String sname = txtName.getText().trim();
			if(sname.length()!=0) {
				// �̸� �Է������� �̸� �˻� ����(conn, pstmt, rs ... close)
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sname);
					rs = pstmt.executeQuery();
					students.clear();
					txtPool.setText("");
					while(rs.next()) {
						String sNo  = rs.getString("sno");
						String sName= rs.getString("sname");
						int mNo     = rs.getInt("mno");
						int score   = rs.getInt("score");
						int sExpel  = rs.getInt("sexpel");
						String mName= rs.getString("mname");
						students.add(new StudentDto(sNo, sName, mNo, score, sExpel, mName));
						txtNo.setText(sNo);
						txtName.setText(sName);
						comMajor.setSelectedItem(mName);
						txtScore.setText(String.valueOf(score));
						//txtScore.setText(rs.getString("score"));
					}
					if(students.size()>1) {
						txtPool.append("\t�й�\t�̸�\t������(������ȣ)\t����\t��������\n");
						for(StudentDto s : students) {
							txtPool.append(s.toString());
						}
					}else if(students.size()==0) {
						txtPool.append("�ش� �̸��� �л��� �����ϴ�");
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
				txtPool.setText("�̸��� �Է� �� �̸� �˻��ϼ���");
			}
		}else if(e.getSource()==btnMajorSearch) {// �����˻�
			String sql = "SELECT S.*, mNAME FROM STUDENT S, MAJOR M WHERE S.MNO=M.MNO AND MNAME=?";
			if(comMajor.getSelectedIndex()!=0) {
				// ���� ���������� ���� �˻� ����(conn, pstmt, rs ... close)
			}else {
				txtPool.setText("������ ���� �� ���� �˻��ϼ���");
			}
		}else if(e.getSource()==btnInput) {//�л��Է�
			String sql = "INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES " + 
					" (?,?, (SELECT mNO FROM MAJOR WHERE mNAME=?),?)";
			String sno   = txtNo.getText().trim();
			String sname = txtName.getText().trim();
			if(!sno.equals("") && !sname.equals("") && comMajor.getSelectedIndex()!=0) {
				// �й�, �̸�, ���� �Է������� �л��Է� ����(conn, pstmt ... close)
			}else {
				txtPool.setText("�й�, �̸�, ������ �Է� �� �л��Է��ϼ���");
			}
		}else if(e.getSource()==btnUpdate) {//�л�����
			String sql = "UPDATE STUDENT SET sNAME=?, " +
					"mNO=(SELECT mNO FROM MAJOR WHERE mNAME=?), " + 
					"        SCORE=? " + 
					"    WHERE sNO=?";
			String sno   = txtNo.getText().trim();
			String sname = txtName.getText().trim();
			if(!sno.equals("") && !sname.equals("") && comMajor.getSelectedIndex()!=0) {
				// �й�, �̸�, ���� �Է������� �л����� ����((conn, pstmt ... close)
			}else {
				txtPool.setText("�й�, �̸�, ������ �Է� �� �л������ϼ���");
			}
		}else if(e.getSource()==btnStudentOut) {//�л����
			String sql = "SELECT S.*, mNAME FROM STUDENT S, MAJOR M WHERE S.mNO=M.mNO AND sEXPEL=0";
			// conn, pstmt, .. close
		}else if(e.getSource()==btnExpel) {//����ó��
			String sql = "UPDATE STUDENT SET sEXPEL=1 WHERE sNO=?";
			String sno = txtNo.getText().trim();
			if(!sno.equals("")) {
				// �й� �Է������� ���� ó�� ����(conn, pstmt, .. close)
			}else {
				txtPool.setText("�й��� �Է� �� ���� ó���ϼ���");
			}
		}else if(e.getSource()==btnExit) {//����
			setVisible(false); dispose(); System.exit(0);
		}else if(e.getSource()==btnExpelOut) {//���������
			String sql = "SELECT S.*, mNAME FROM STUDENT S, MAJOR M WHERE S.mNO=M.mNO AND sEXPEL=1";
			// conn, pstmt, .., close
		}
		
	}
	public static void main(String[] args) {
		new StudentMng("�л�����");
	}
}
