package com.tj.awt;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Ex2LoginFrame extends Frame implements ActionListener {
	private Label lbl1, lbl2;
	private TextField txtId, txtPw;
	private Button btn;
	public Ex2LoginFrame(String title) {
		super(title);
		lbl1 = new Label("아이디");
		txtId = new TextField("ID", 20);
		lbl2 = new Label("비밀번호");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		btn = new Button("LOGIN");
		setLayout(new FlowLayout()); // frame의 레이아웃스타일 수정
		add(lbl1); add(txtId);
		add(lbl2); add(txtPw);
		add(btn);
		setSize(new Dimension(290, 150));
		setLocation(200, 100);// 안쓰면 setLocation(0, 0)가 default
		setVisible(true);
		//setResizable(false); // 창의 사이즈 조정 불가
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				//System.exit(0);
			}
		});
	}
	public Ex2LoginFrame() {
		this("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
