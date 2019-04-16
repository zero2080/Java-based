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
	// GUI 컴포넌트 변수
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
	// JDBC 관련변수
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
		btnNoSearch = new JButton("학번검색");
		btnNameSearch = new JButton("이름검색");
		btnMajorSearch = new JButton("학번검색");
		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		btnExpel = new JButton("제적처리");
		btnExit = new JButton("종료");
		btnExpelOut = new JButton("제적자출력");
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("학번", (int) CENTER_ALIGNMENT));
		jpup.add(txtNo);
		jpup.add(btnNoSearch);
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(btnNameSearch);
		jpup.add(new JLabel("전공", (int) CENTER_ALIGNMENT));
		jpup.add(comMajor);
		jpup.add(btnMajorSearch);
		jpup.add(new JLabel("점수", (int) CENTER_ALIGNMENT));
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
		if(e.getSource()==btnNoSearch) {//학번검색
			String sql = "SELECT S.*, mNAME FROM STUDENT S, MAJOR M "
					+ "WHERE S.MNO=M.MNO AND sNO=?";
			String sno = txtNo.getText().trim();
			if(!sno.equals("")) {
				// 학번 입력했으면 학번 검색 시작(conn, pstmt, rs ... close)
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
						txtPool.setText(sno+"검색 완료");
					}else {
						txtPool.setText("없는 학번입니다");
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
				txtPool.setText("학번을 입력 후 학번 검색하세요");
			}
		}else if(e.getSource()==btnNameSearch) {//이름검색
			String sql = "SELECT S.*, mNAME FROM STUDENT S, MAJOR M "
					+ "WHERE S.MNO=M.MNO AND sNAME=?";
			String sname = txtName.getText().trim();
			if(sname.length()!=0) {
				// 이름 입력했으면 이름 검색 시작(conn, pstmt, rs ... close)
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
						txtPool.append("\t학번\t이름\t전공명(전공번호)\t점수\t제적유무\n");
						for(StudentDto s : students) {
							txtPool.append(s.toString());
						}
					}else if(students.size()==0) {
						txtPool.append("해당 이름의 학생이 없습니다");
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
				txtPool.setText("이름을 입력 후 이름 검색하세요");
			}
		}else if(e.getSource()==btnMajorSearch) {// 전공검색
			String sql = "SELECT S.*, mNAME FROM STUDENT S, MAJOR M WHERE S.MNO=M.MNO AND MNAME=?";
			if(comMajor.getSelectedIndex()!=0) {
				// 전공 선택했으면 전공 검색 시작(conn, pstmt, rs ... close)
			}else {
				txtPool.setText("전공을 선택 후 전공 검색하세요");
			}
		}else if(e.getSource()==btnInput) {//학생입력
			String sql = "INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES " + 
					" (?,?, (SELECT mNO FROM MAJOR WHERE mNAME=?),?)";
			String sno   = txtNo.getText().trim();
			String sname = txtName.getText().trim();
			if(!sno.equals("") && !sname.equals("") && comMajor.getSelectedIndex()!=0) {
				// 학번, 이름, 전공 입력했으면 학생입력 시작(conn, pstmt ... close)
			}else {
				txtPool.setText("학번, 이름, 전공을 입력 후 학생입력하세요");
			}
		}else if(e.getSource()==btnUpdate) {//학생수정
			String sql = "UPDATE STUDENT SET sNAME=?, " +
					"mNO=(SELECT mNO FROM MAJOR WHERE mNAME=?), " + 
					"        SCORE=? " + 
					"    WHERE sNO=?";
			String sno   = txtNo.getText().trim();
			String sname = txtName.getText().trim();
			if(!sno.equals("") && !sname.equals("") && comMajor.getSelectedIndex()!=0) {
				// 학번, 이름, 전공 입력했으면 학생수정 시작((conn, pstmt ... close)
			}else {
				txtPool.setText("학번, 이름, 전공을 입력 후 학생수정하세요");
			}
		}else if(e.getSource()==btnStudentOut) {//학생출력
			String sql = "SELECT S.*, mNAME FROM STUDENT S, MAJOR M WHERE S.mNO=M.mNO AND sEXPEL=0";
			// conn, pstmt, .. close
		}else if(e.getSource()==btnExpel) {//제적처리
			String sql = "UPDATE STUDENT SET sEXPEL=1 WHERE sNO=?";
			String sno = txtNo.getText().trim();
			if(!sno.equals("")) {
				// 학번 입력했으면 제적 처리 시작(conn, pstmt, .. close)
			}else {
				txtPool.setText("학번을 입력 후 제적 처리하세요");
			}
		}else if(e.getSource()==btnExit) {//종료
			setVisible(false); dispose(); System.exit(0);
		}else if(e.getSource()==btnExpelOut) {//제적자출력
			String sql = "SELECT S.*, mNAME FROM STUDENT S, MAJOR M WHERE S.mNO=M.mNO AND sEXPEL=1";
			// conn, pstmt, .., close
		}
		
	}
	public static void main(String[] args) {
		new StudentMng("학생관리");
	}
}
