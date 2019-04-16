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
		btnMajorSearch = new JButton("전공검색");
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
		}else if(e.getSource()==btnNameSearch){ // 이름검색
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
					String temp = "\t학번\t이름\t학과명\t점수\t제적여부\n";
					temp += "────────────────────────────────────────────\n";
					if(students.size()==0) {
						temp += "\t 해당 이름의 학생이 없습니다";
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
				txtPool.setText("이름은 입력하고 검색해야지");
			}
		}else if(e.getSource()==btnMajorSearch) { //전공검색
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
					String temp = "\t학번\t이름\t학과명\t점수\t제적여부\n";
					temp += "────────────────────────────────────────────\n";
					if(students.size()!=0) {
						for(StudentDto s : students) {
							temp += s.toString();
						}
					}else {
						temp += "\t 해당 학생이 없습니다";
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
				txtPool.setText("전공은 선택하고 검색해야지");
			}
		}else if(e.getSource()==btnInput){ // 학생입력
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
							System.out.println("유효한 점수가 아니면 0점처리");
							score = 0;
						}
					}catch (Exception e1) {
						System.out.println("입력안하거나 문자면 0점");
					}
					pstmt.setInt(4, score);
					int result = pstmt.executeUpdate();
					System.out.println(result>0? "학생입력성공":"학생입력실패");
					txtPool.setText(result>0? "학생입력성공":"학생입력실패");
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
				txtPool.setText("학생입력시 학번, 이름, 전공을 입력해야해");
			}
		}else if(e.getSource()==btnUpdate) { //학생수정
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
							System.out.println("유효한 점수가 아니면 0점처리");
							score = 0;
						}
					}catch (Exception e1) {
						System.out.println("입력안하거나 문자면 0점");
					}
					pstmt.setInt(3, score);
					pstmt.setString(4, sno);
					int result = pstmt.executeUpdate();
					System.out.println(result>0? "학생수정성공":"학생수정실패");
					txtPool.setText(result>0? "학생수정성공":"학생수정실패");
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if(pstmt!= null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e1) {System.out.println(e1.getMessage());}
				}
			}else {
				txtPool.setText("학생수정시 학번, 이름, 전공을 입력해야해");
			}
		}else if(e.getSource()==btnStudentOut){ // 학생출력
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
					student.setsExpel(sexpel==0? "학생":"제적자");
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
				txtPool.setText("\t학번\t이름\t학과명\t점수\t제적여부\n");
				txtPool.append("────────────────────────────────────────────\n");
				if(!students.isEmpty()) {
					for(StudentDto s : students) {
						txtPool.append(s.toString());
					}
				}else {
					txtPool.append("\t 해당 학생이 없습니다");
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
		}else if(e.getSource()==btnExpel) { // 제적처리
			String sql = "UPDATE STUDENT SET sEXPEL=1 WHERE sNO=?";
			String sno = txtNo.getText().trim();
			if(sno.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sno);
					int result = pstmt.executeUpdate();
					if(result>0) {
						System.out.println("제적처리 성공");
						txtPool.setText("제적처리 성공");
					}else {
						System.out.println("해당 학번이 없어 제적처리 불가");
						txtPool.setText("해당 학번이 없어 제적처리 불가");
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
				txtPool.setText("학번은 입력하고 제적처리해야지");
			}
		}else if(e.getSource()==btnExit){ // 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}else if(e.getSource()==btnExpelOut) { //제적자 출력
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
				txtPool.setText("\t학번\t이름\t학과명\t점수\t제적여부\n");
				txtPool.append("────────────────────────────────────────────\n");
				if(!students.isEmpty()) {
					for(StudentDto s : students) {
						txtPool.append(s.toString());
					}
				}else {
					txtPool.append("\t 해당 학생이 없습니다");
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
		new StudentMng("학생관리");
	}
}
