package com.tj.ex;
public class VarEx02 {
	public static void main(String[] args) {
		int i = 10; // i��� ������ 10�� �Ҵ��Ѵ�
		byte j = 20;
		int h = 0;
		char c1 = '��';
		char c2 = '��';
		char c3 = '��';
		// ��� ��� println, print, printf
		// "\t" ��   "\n"����
		System.out.println(i+"\t"+j+"\t"+h); // ��������
		System.out.print(c1+"\t"+c2+"\t"+c3+"\n");
		System.out.printf("c1�ڵ�=%d, c2�ڵ�=%d",(int)c1, (int)c2);
		// %d������� / %c�������/ %s���ڿ���� / %f�Ǽ���� / %x16�������
		
	}
}
