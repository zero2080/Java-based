package com.tj.ex3;
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
public class CustomerMng extends JFrame implements ActionListener {
	//Swing
	private Container container;
	private JPanel jpup, jpbtn;
	private JTextField jtxtTel, jtxtName, jtxtPoint, jtxtAmount;
	private Vector<String> levels;
	private JComboBox<String> jcomLevel;
	private JButton jbtnTelSearch, jbtnNameSearch, jbtnPoint;
	private JButton jbtnBuy, jbtnLevelOutput, jbtnAllOutput, 
				jbtnInsert, jbtnTelUpdate, jbtnDelete, jbtnExit;
	private JTextArea jtxtPool;
	private JScrollPane scrollPane;
	//JDBC
	private String driver;
	private String url;
	private Connection conn;
	private PreparedStatement pstmt;
	private PreparedStatement pstmt2;
	private ResultSet rs;
	public CustomerMng(String title) {
		super(title);
		driver = "oracle.jdbc.driver.OracleDriver";
		url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(5, 3));
		jpbtn = new JPanel();
		jtxtTel = new JTextField(20);
		jtxtName = new JTextField(20);
		jtxtPoint = new JTextField(20);
		jtxtAmount = new JTextField(20);
		levels = new Vector<String>();
		levels.add("");
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement("SELECT LEVELNAME FROM CUS_LEVEL");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				levels.add(rs.getString("levelname"));
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) { }
		}
		jcomLevel = new JComboBox<String>(levels);
		jbtnTelSearch = new JButton("��4�ڸ�(FULL) �˻�");
		jbtnNameSearch = new JButton("�� �̸� �˻�");
		jbtnPoint = new JButton("����Ʈ�θ� ����");
		jpup.add(new JLabel("�� �� �� ȭ",(int) CENTER_ALIGNMENT));
		jpup.add(jtxtTel);
		jpup.add(jbtnTelSearch);
		jpup.add(new JLabel("�� �� �� ��",(int) CENTER_ALIGNMENT));
		jpup.add(jtxtName);
		jpup.add(jbtnNameSearch);
		jpup.add(new JLabel("��  ��  Ʈ",(int) CENTER_ALIGNMENT));
		jpup.add(jtxtPoint);
		jpup.add(jbtnPoint);
		jpup.add(new JLabel("�� �� �� ��",(int) CENTER_ALIGNMENT));
		jpup.add(jtxtAmount);
		jpup.add(new JLabel(""));//�� �� �߰��ϴ� �κ�
		jpup.add(new JLabel("�� �� �� ��",(int) CENTER_ALIGNMENT));
		jpup.add(jcomLevel);
		jbtnBuy         = new JButton("��ǰ ����");
		jbtnLevelOutput = new JButton("��޺����");
		jbtnAllOutput   = new JButton("��ü���");
		jbtnInsert      = new JButton("ȸ������");
		jbtnTelUpdate   = new JButton("��ȣ����");
		jbtnDelete      = new JButton("ȸ��Ż��");
		jbtnExit        = new JButton("������");
		jpbtn.add(jbtnBuy);
		jpbtn.add(jbtnLevelOutput);
		jpbtn.add(jbtnAllOutput);
		jpbtn.add(jbtnInsert);
		jpbtn.add(jbtnTelUpdate);
		jpbtn.add(jbtnDelete);
		jpbtn.add(jbtnExit);
		jtxtPool = new JTextArea(6, 60);
		scrollPane = new JScrollPane(jtxtPool);
		container.add(jpup);
		container.add(jpbtn);
		container.add(scrollPane);
		setSize(new Dimension(750, 370));setLocation(200, 200);
		setVisible(true);
		jbtnTelSearch.addActionListener(this);
		jbtnNameSearch.addActionListener(this);
		jbtnPoint.addActionListener(this);
		jbtnBuy.addActionListener(this);
		jbtnLevelOutput.addActionListener(this);
		jbtnAllOutput.addActionListener(this);
		jbtnInsert.addActionListener(this);
		jbtnTelUpdate.addActionListener(this);
		jbtnDelete.addActionListener(this);
		jbtnExit.addActionListener(this);
		jtxtPool.setText("\t�� �� �� ���˻� �� �����ϼ��� �� �� ��");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtnTelSearch) {//�� 4�ڸ�(FULL) �˻�
			String sql = "SELECT C.*, LEVELNAME, LOW, HIGH,  " + 
					"        (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER "+
					 				"WHERE CID=C.CID AND LEVELNO<>5) LEVELUP " + 
					"    FROM CUSTOMER C, CUS_LEVEL L " + 
					"    WHERE CAMOUNT BETWEEN LOW AND HIGH AND CTEL LIKE '%'||?";
			String ctel = jtxtTel.getText().trim();
			if(ctel.length() >= 4) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ctel);
					rs = pstmt.executeQuery();
					ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
					while(rs.next()) {
						ctel = rs.getString("ctel");
						String cname = rs.getString("cname");
						int cpoint = rs.getInt("cpoint");
						int camount = rs.getInt("camount");
						String levelname= rs.getString("levelname");
						int levelup = rs.getInt("levelup");
						customers.add(new CustomerDto(ctel, cname, cpoint, camount, levelname, levelup));
						jtxtTel.setText(ctel);
						jtxtName.setText(cname);
						jtxtPoint.setText(String.valueOf(cpoint));
						jcomLevel.setSelectedItem(levelname);
					}
					jtxtPool.setText("��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� ������ ������ �ݾ�\n");
					jtxtPool.append("����������������������������������������������������������������������������������������������������������\n");
					if(customers.size()==0) {
						jtxtPool.append("�ش� ��ȭ��ȣ�� �����ϴ�");
						jtxtTel.setText("");
						jtxtName.setText("");
						jtxtPoint.setText("");
						jcomLevel.setSelectedIndex(0);
					}else {
						for(CustomerDto c : customers)
							jtxtPool.append(c.toString()+"\n");
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}finally {
					try{
						if(rs!=null) rs.close(); 
						if(pstmt!=null)pstmt.close();
						if(conn!=null)  conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
				
			}else {
				jtxtPool.setText("��� ��4�ڸ� �̻� �Է��Ͻð� �˻��ϼ���");
			}
		}else if(e.getSource()==jbtnNameSearch) {//�̸��˻�
			String sql = "SELECT C.*, LEVELNAME, LOW, HIGH,  " + 
					"        (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER "+
					 					"WHERE CID=C.CID AND LEVELNO<>5) LEVELUP " + 
					"    FROM CUSTOMER C, CUS_LEVEL L " + 
					"    WHERE CAMOUNT BETWEEN LOW AND HIGH AND CNAME=?";
			String ename = jtxtName.getText().trim();
			if(ename.length()!=0) {
				try {
					conn=DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ename);
					rs = pstmt.executeQuery();
					ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
					while(rs.next()) {
						String ctel = rs.getString("ctel");
						String cname = rs.getString("cname");
						int cpoint = rs.getInt("cpoint");
						int camount = rs.getInt("camount");
						String levelname = rs.getString("levelname");
						int levelup = rs.getInt("levelup");
						jtxtTel.setText(ctel);
						jtxtName.setText(cname);
						jtxtPoint.setText(String.valueOf(cpoint));
						jcomLevel.setSelectedItem(levelname);
						customers.add(new CustomerDto(ctel, cname, cpoint, camount, levelname, levelup));
					}
					jtxtPool.setText("��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� ������ ������ �ݾ�\n");
					jtxtPool.append("����������������������������������������������������������������������������������������������������������\n");
					if(!customers.isEmpty())
						for(CustomerDto c : customers)
							jtxtPool.append(c.toString());
					else
						jtxtPool.append("�ش� �̸��� ���� �����");
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try{
						if(rs!=null) rs.close(); 
						if(pstmt!=null)pstmt.close();
						if(conn!=null)  conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("�̸��� �Է��Ͻ� �� �̸��˻��ϼ���");
			}//if �̸��Է� ����
		}else if(e.getSource()==jbtnPoint) {// ����Ʈ����
			String sql = "UPDATE CUSTOMER SET cPOINT=CPOINT-? WHERE cTEL=?";
			int cpoint  = Integer.parseInt(jtxtPoint.getText());
			int camount = Integer.parseInt(jtxtAmount.getText());
			if(cpoint>=camount) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, camount);
					pstmt.setString(2, jtxtTel.getText().trim());
					int result = pstmt.executeUpdate();
					if(result>0) {
						jtxtPool.setText("����Ʈ�θ� ���� ����");
						jtxtPoint.setText(String.valueOf(cpoint-camount));
						jtxtAmount.setText("");
					}else {
						jtxtPool.setText("��ȭ��ȣ�� Ȯ���ϼ���. �ش� ��ȭ��ȣ�� �����ϴ�");
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try{
						if(rs   !=null) rs.close(); 
						if(pstmt!=null) pstmt.close();
						if(conn !=null) conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("����Ʈ�� �����ؼ� ����Ʈ ������ �Ұ��ؿ�");
			} // if ����Ʈ�θ� ���Ű�������
		}else if(e.getSource()==jbtnBuy) {//��ǰ����
			String sql1 = "UPDATE CUSTOMER SET cPOINT=cPOINT+?*0.05, " +
										"cAMOUNT=cAMOUNT+? " + 
								"    WHERE cTEL=?";
			String sql2 = "UPDATE CUSTOMER SET " +
					 "LEVELNO=(SELECT L.LEVELNO FROM CUSTOMER C, CUS_LEVEL L " + 
					"             WHERE cAMOUNT BETWEEN LOW AND HIGH AND cTEL=?) "+ 
					"            WHERE cTEL=?";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql1);
				int camount = Integer.parseInt(jtxtAmount.getText().trim());
				int cpoint = Integer.parseInt(jtxtPoint.getText());
				String tel = jtxtTel.getText().trim();
				pstmt.setInt(1, camount);
				pstmt.setInt(2, camount);
				pstmt.setString(3, tel);
				int result = pstmt.executeUpdate();
				if(result>0) {
					jtxtPool.setText("��ǰ���� ������ �����ݾ����� �ٽ� ���� �ο��մϴ�\n");
					pstmt2 = conn.prepareStatement(sql2);
					pstmt2.setString(1, tel);
					pstmt2.setString(2, tel);
					jtxtPool.append(pstmt2.executeUpdate()>0? "���� �ο� ����":"���� �ο� ����");
					int updatePoint = (int)(cpoint+camount*0.05);
					jtxtPoint.setText(String.valueOf(updatePoint));
					jtxtAmount.setText("");
				}else {
					jtxtPool.setText("��ǰ���� ����");
				}
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}finally {
				try{
					if(pstmt2!=null) pstmt2.close();
					if(pstmt !=null) pstmt.close();
					if(conn  !=null) conn.close();
				}catch (Exception ignored) { }
			}//try-catch-finally
		}else if(e.getSource()==jbtnLevelOutput) {//��޺� ���
			String sql = "SELECT C.*, LEVELNAME,  " + 
				" (select HIGH-cAMOUNT+1 FROM CUSTOMER "+
				 			"WHERE CID=C.CID AND LEVELNO<>5) LEVELUP " + 
				" FROM CUSTOMER C, CUS_LEVEL L " + 
				" WHERE C.LEVELNO=L.LEVELNO AND LEVELNAME=?";
			if(jcomLevel.getSelectedIndex()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, jcomLevel.getSelectedItem().toString());
					rs = pstmt.executeQuery();
					ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
					while(rs.next()) {
						String ctel = rs.getString("ctel");
						String cname = rs.getString("cname");
						int cpoint = rs.getInt("cpoint");
						int camount = rs.getInt("camount");
						String levelname= rs.getString("levelname");
						int levelup = rs.getInt("levelup");
						customers.add(new CustomerDto(ctel, cname, cpoint, camount, levelname, levelup));
					}
					jtxtPool.setText("��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� ������ �ݾ�\n");
					jtxtPool.append("����������������������������������������������������������������������������������������������������������\n");
					if(customers.isEmpty()) {
						jtxtPool.append("�ش� ������ ���� �����ϴ�\n");
					}else {
						for(CustomerDto c : customers)
							jtxtPool.append(c.toString());
					}
					jtxtPool.append("����������������������������������������������������������������������������������������������������������\n");
					jtxtPool.append("�� "+customers.size()+"��");
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}finally {
					try{
						if(rs   !=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn !=null) conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("����� ���� �� ��޺� ����� Ŭ���ϼ���");
			}
		}else if(e.getSource()==jbtnAllOutput) {//��ü���
			String sql = "SELECT C.*, LEVELNAME,  " + 
					"    (select HIGH-cAMOUNT+1 from customer where cid=c.cid and levelno<>5) LEVELUP " + 
					"    FROM CUSTOMER C, CUS_LEVEL L " + 
					"    WHERE C.LEVELNO=L.LEVELNO";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
				while(rs.next()) {
					String ctel = rs.getString("ctel");
					String cname = rs.getString("cname");
					int cpoint = rs.getInt("cpoint");
					int camount = rs.getInt("camount");
					String levelname= rs.getString("levelname");
					int levelup = rs.getInt("levelup");
					customers.add(new CustomerDto(ctel, cname, cpoint, camount, levelname, levelup));
				}
				jtxtPool.setText("��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� ������ ������ �ݾ�\n");
				jtxtPool.append("������������������������������������������������������������������������������������������������������\n");
				if(customers.isEmpty()) {
					jtxtPool.append("�ش� ���� �����ϴ�");
				}else {
					for(CustomerDto c : customers)
						jtxtPool.append(c.toString());
				}
				jtxtPool.append("������������������������������������������������������������������������������������������������������\n");
				jtxtPool.append("�� "+customers.size()+"��");
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}finally {
				try{
					if(rs!=null)  rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)  conn.close();
				}catch (Exception ignored) { }
			}//try-catch-finally
		}else if(e.getSource()==jbtnInsert) {//ȸ������
			String sql = "INSERT INTO CUSTOMER (cID, cTEL, cNAME) VALUES"
							+ " (CUSTOMER_SEQ.NEXTVAL, ?, ?)";
			String ctel = jtxtTel.getText().trim();
			String cname = jtxtName.getText().trim();
			if(ctel.length()!=0 && cname.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ctel);
					pstmt.setString(2, cname);
					int result = pstmt.executeUpdate();
					if(result>0) {
						jtxtPool.setText("ȸ������ �����մϴ�. ����Ʈ 1000���� ȸ�����Լ����� �帳�ϴ�");
						jtxtPoint.setText("1000");
						jcomLevel.setSelectedIndex(1);
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try{
						if(pstmt!=null)pstmt.close();
						if(conn!=null)  conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("��ȭ��ȣ�� �̸��� �Է��� ȸ�������� �����ؿ�");
			}// if ȸ�����Խ� ��ȭ��ȣ�� �̸��� �Է��ؾ� ����
		}else if(e.getSource()==jbtnTelUpdate) {//��ȣ����
			String sql = "UPDATE CUSTOMER SET cTEL=? WHERE cNAME=?";
			String ctel = jtxtTel.getText().trim();
			String cname = jtxtName.getText().trim();
			if(ctel.length()!=0 && cname.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ctel);
					pstmt.setString(2, cname);
					int result = pstmt.executeUpdate();
					if(result>0) {
						jtxtPool.setText("��ȣ ������ �Ϸ�Ǿ����ϴ�");
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try{
						if(pstmt!=null)pstmt.close();
						if(conn!=null)  conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("��ȭ��ȣ�� �̸��� �Է��� ��ȣ������ �����ؿ�");
			}// if ��ȣ������ ��ȭ��ȣ�� �̸��� �Է��ؾ� ����
		}else if(e.getSource()==jbtnDelete) {//ȸ��Ż��
			String sql = "DELETE CUSTOMER WHERE cTEL=?";
			String ctel = jtxtTel.getText().trim();
			if(ctel.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ctel);
					int result = pstmt.executeUpdate();
					if(result>0) {
						jtxtPool.setText(jtxtTel.getText().trim()+"�� ȸ�� Ż�� �Ϸ�Ǿ����ϴ�");
						jtxtTel.setText(""); jtxtName.setText(""); jtxtPoint.setText(""); 
						jcomLevel.setSelectedIndex(0);
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try{
						if(pstmt!=null)pstmt.close();
						if(conn!=null)  conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("��ȭ��ȣ �Է��� ȸ��Ż�� �����ؿ�");
			} // if ȸ��Ż��� ��ȭ��ȣ�� �ԷµǾ� �־�� ����
		}else if(e.getSource()==jbtnExit) {//������
			setVisible(false); dispose(); System.exit(0);
		}
	}
	public static void main(String[] args) {
		new CustomerMng("������");
	}
}
