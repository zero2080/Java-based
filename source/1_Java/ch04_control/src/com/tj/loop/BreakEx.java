package com.tj.loop;
// break vs. continue
public class BreakEx {
	public static void main(String[] args) {
		for(int i=0 ; i<=5 ; i++) {
			if(i==3) break; // �ݺ����� �������� �ݺ��� ����
			System.out.println(i);
		}
		for(int i=0 ; i<=5 ; i++) {
			if(i==3) continue; // �ݺ����� �����ͼ� �����η� ��
			System.out.println(i);
		}
	}
}
