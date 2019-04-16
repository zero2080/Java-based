package com.tj.swing;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Ex4 extends JFrame implements ActionListener{
	private Container contenPane;
	private JPanel    jpup, jpdown;
	private JTextField jtxtName, jtxtTel, jtxtAge;
	private JButton   jbtnWrite;
	private ImageIcon icon;
	public Ex4() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		jpup = new JPanel();
		jpup.setLayout(new GridLayout(3, 2));
		jpdown = new JPanel();
		jpdown.setLayout(new FlowLayout());
		jtxtName = new JTextField();
		jtxtTel = new JTextField();
		jtxtAge = new JTextField();
		icon = new ImageIcon("icon/write.gif");
		jbtnWrite = new JButton("콘솔출력", icon);
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtName);
		jpup.add(new JLabel("전화", (int)CENTER_ALIGNMENT));
		jpup.add(jtxtTel);
		jpup.add(new JLabel("나이", (int)CENTER_ALIGNMENT));
		jpup.add(jtxtAge);
		jpdown.add(jbtnWrite);
		contenPane.add(jpup, BorderLayout.CENTER);
		contenPane.add(jpdown, BorderLayout.SOUTH);
		/*setLocation(100, 100);
		setSize(new Dimension(200, 200));*/
		setBounds(100, 100, 300, 200);
		setVisible(true);
		jbtnWrite.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtnWrite) {
			String name = jtxtName.getText();
			String tel = jtxtTel.getText();
			if(name.trim().equals("")) {
				System.out.println("이름를 입력하세요"); jtxtName.setText("");return;
			}
			if(tel.trim().equals("")||tel.indexOf("-")==-1) {
				System.out.println("전화를 제대로 입력하세요");jtxtTel.setText("");return;
			}
			int age;
			try {
				age = Integer.parseInt(jtxtAge.getText());
			}catch (Exception e1) {
				System.out.println("나이는 수로 입력해요.");jtxtAge.setText("");return;
			}
			if(age>120 || age<0) {
				System.out.println("제대로 된 나이를 입력하셔야 합니다.");
				jtxtAge.setText("");return;
			}
			System.out.println("이름은 "+name+", 전화는 "+tel+",나이는 "+age+"살입니다");
			jtxtName.setText("");
			jtxtTel.setText("");
			jtxtAge.setText("");
		}
	}

}







