package com.tj.ex3_student;
import java.util.Scanner;
public class StudentTestMain {
	public static void main(String[] args) {
		Student[] st = {new Student(20181,"ȫ�浿",22,"��ǻ�Ͱ���"),
				new Student(20182,"�ű浿",23,"�������"),
				new Student(20183,"���浿",22,"�濵����"),
				new Student(20184,"��浿",24,"�������"),
				new Student(20185,"���浿",20,"�濵����")};
		StudentExpel expel = new StudentExpel();
		for(Student s : st) {//������ ������
			System.out.println(s.infoString());
		}
		// st[0]���� st[4]���� ���̸� ���쾿 ��������
		for(Student s : st) {
			s.setAge(s.getAge()+1);//���� �ϳ� ������Ű��
			s.modify(3, String.valueOf(s.getAge()+1));//����+1�� ��Ʈ������ �ٲ�
			s.modify(3, s.getAge()+1+"");//����+1�� ��Ʈ������ �ٲ�
		}//for
		for(Student s : st) {
			s.print();
		}
		Scanner sc = new Scanner(System.in);
		int hakbun, fn, idx;
		String data;
		while(true) {
			// 1.�й�(hakbun) �Է¹ޱ�(����:0)
			System.out.print("ó���� �й��� ?(��, ����� 0)");
			hakbun = sc.nextInt();
			// 2.hakbun==0 �̸� break;
			if(hakbun==0) break;
			// 3.�Էµ� hakbun�� st[0]���� �й��� ��ȸ�Ѵ� - �Է��� �й��� ã�´�
			for(idx=0 ; idx<st.length ; idx++) {
				if(st[idx].getHakbun()==hakbun) {
					break;//�Է��� �й��� ã���� for�� ��������
				}
			}//for
			if(idx==st.length) {
				System.out.println("��ȿ�� �й��� �ƴϾ� �ٽ��ϴ���");
				continue;
			}
			// 4.��ɹ�ȣ(fn:1~4)�� �Է¹޾�
			System.out.print("���ϴ� �����?(1:�й�, 2:�̸�, 3:����, 4:�а�)");
			fn = sc.nextInt();
			if(fn<1 || fn>4) {
				System.out.println("��ȿ�� ��ɹ�ȣ�� �ƴϾ�. ����");
			}else {
				// 5.������ ������(data)�� �޾�
				System.out.print("�ٲ� �����ʹ�? ");
				data = sc.next(); //��Ʈ������ �Է¹޾� data�� �Ҵ�
				// 6. ������ ������ ���
				System.out.println("������ ������ : "+st[idx].infoString());
				// 7.modify�޼ҵ带 �̿��ؼ� ����
				st[idx].modify(fn, data);
				// 8.���� �� ������ ���
				System.out.println("������ ������ : "+st[idx].infoString());
			}//if
		}// while
		System.out.println("�߰� �̶����� ������ �л� �����;�");
		for(Student s : st)
			s.print();
	}//main
}//class












