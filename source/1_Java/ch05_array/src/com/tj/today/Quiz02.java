package com.tj.today;
// 2���� �迭������ ������ ���
public class Quiz02 {
	public static void main(String[] args) {
		int[][] arr = {{5,5,5,5,5},{10,10,10,10,10},{20,20,20,20,20},{30,30,30,30,30}};
		int tot = 0; // ��ü ���� ����
		int[] rowTot = new int[arr.length]; // rowTot[0] ~ rowTot[3]
		for(int i=0 ; i<arr.length ; i++) { // 0~3 �����
			for(int j=0 ; j<arr[i].length ; j++) { // i���� 0~4 ������
				tot += arr[i][j]; //tot = tot + arr[i][j]; ��ü ����
				rowTot[i] += arr[i][j]; // �ະ ����
			}
		}
		// ���� �ະ ������ ��ü ���� ���
		for(int i=0 ; i<rowTot.length ; i++) {
			System.out.println(i+"��° ���� ���� "+rowTot[i]);
		}
		System.out.println("��ü �������� "+tot);
	}
}
