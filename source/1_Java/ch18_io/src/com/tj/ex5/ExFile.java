package com.tj.ex5;
import java.io.File;
public class ExFile {
	public static void main(String[] args) {
		File file1 = new File("d:/mega_IT/aa.txt");// ������ �̿��ؼ� ����
		File fold  = new File("d:/mega_IT");       // ������ �̿��ؼ� ����
		if(file1.exists()) {
			System.out.println("�����ϴ� �����̳� �����Դϴ�");
		}else {
			System.out.println("�������� �ʴ� �����̳� �����Դϴ�");
		}
		File file = new File("."); // ��������Ʈ ����
		String[] dirList = file.list(); // file ���� ������ ������ �̸��� dirList�� ����
		File[] files = file.listFiles();// file���� ������ ������ File�迭��ü�� ����
		System.out.println("�����̸�\t\t��������\t����ũ��");
		for(File f : files){
			if(f.getName().length()>=8)
				System.out.print(f.getName() + "\t");//�����̸����
			else
				System.out.print(f.getName()+"\t\t");
			System.out.print(f.isDirectory()? "����":"����");
			System.out.println("\t"+f.length()); //����ũ��
		}
	}
}
