package com.tj.swing;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Ex2 extends JFrame implements ActionListener{
	private JPanel jp;
	private JLabel jl, jlblank;
	private JButton jBtn, jBtnExit;
	private JTextField jtxtField;
	private JComboBox<String> jcombo;
	private Vector<String> itemVec;
	//private String[] itemArr = {"A","B","C"};
	private JCheckBox jchk;
	public Ex2() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jp = (JPanel) getContentPane();
		jp.setLayout(new FlowLayout());
		jl = new JLabel("Label");
		jBtn = new JButton("Button");
		jtxtField = new JTextField(20);
		itemVec = new Vector<String>();
		itemVec.add("A"); itemVec.add("B"); itemVec.add("C");
		itemVec.add("D");
		//jcombo = new JComboBox<String>(itemArr);
		jcombo = new JComboBox<String>(itemVec);
		jchk = new JCheckBox("CheckBox");
		jlblank = new JLabel(); // 빈 스트링 라벨
		jBtnExit = new JButton("Exit");
		jp.add(jl);		jp.add(jBtn);  jp.add(jtxtField);
		jp.add(jcombo); jp.add(jchk);  jp.add(jlblank);
		jp.add(jBtnExit);
		jl.setPreferredSize(new Dimension(50, 50));
		jBtn.setPreferredSize(new Dimension(100, 50));
		jtxtField.setPreferredSize(new Dimension(300, 50));
		jcombo.setPreferredSize(new Dimension(100, 50));
		jchk.setPreferredSize(new Dimension(100, 50));
		jlblank.setPreferredSize(new Dimension(200, 50));
		jBtnExit.setPreferredSize(new Dimension(100, 50));
		setVisible(true);
		pack();
		setLocation(200, 100);
		// 이벤트처리할 컴포넌트들 addActionListener
		jBtn.addActionListener(this);
		jcombo.addActionListener(this);
		jchk.addActionListener(this);
		jBtnExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jBtn) {
			if(jtxtField.getText().trim().equals("")) return;
			jlblank.setText(jtxtField.getText().trim());
			jcombo.addItem(jtxtField.getText().trim());
			jtxtField.setText("");
		}else if(e.getSource()==jcombo) {
			jlblank.setText(jcombo.getSelectedItem().toString());
		}else if(e.getSource()==jchk) {
			if(jchk.isSelected()) { // checkBox를 체크되어 있을 때
				jlblank.setText(jchk.getText());
			}else { // 체크를 풀 때
				jlblank.setText("체크를 풀었네");
			}
		}else if(e.getSource()==jBtnExit) {
			String answer = JOptionPane.showInputDialog("진짜 나갈거야(y 후 확인)");
			if(answer.equalsIgnoreCase("y")) {
				setVisible(false); 
				dispose();
				System.exit(0);
			}
		}
	}
}








