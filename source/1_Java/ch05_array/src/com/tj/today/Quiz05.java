package com.tj.today;
import java.util.Scanner;
// ����, ö��, �浿, ����, ���� Ű(180,190,160,170,200))
// String[] names = {"����","ö��", "�浿","����","����"}
// int[] heights = {180,190,160,170,200}
// ���� ��
// names = {"�浿","����","����","ö��","����"}
// heights = {160,170,180,190,200}
// �Ϲ� for���� �̿��ؼ� �浿(160), ����(170), ����(180), ö��(190), ����(200)
public class Quiz05 {
	public static void main(String[] args) {
		String[] names = {"����","ö��", "�浿","����","����"};
		int[] heights = new int[names.length];
		Scanner sc = new Scanner(System.in);
		for(int i=0 ; i<names.length ; i++) {
			System.out.print(names[i]+"�� Ű�� ?");
			heights[i] = sc.nextInt();
		}// Ű �Է� �Ϸ� for��
		for(int i=0 ; i<names.length ; i++) {
			System.out.print(names[i]+"("+heights[i]+"), ");
		}
		System.out.println();
		for(int i=0 ; i<heights.length ; i++) {
			for(int j=i+1 ; j<heights.length ; j++) {
				if(heights[i]>heights[j]) {
					// heights[i]�� heights[j]��ȯ
					int temp = heights[i];
					heights[i] = heights[j];
					heights[j] = temp;
					// names[i]�� names[j] ��ȯ
					String tempName = names[i];
					names[i] = names[j];
					names[j] = tempName;
				}// ��ȯ if
			}//for - j
		}//for-i ���ĿϷ�
		for(int i=0 ; i<names.length ; i++) {
			System.out.print(names[i]+"("+heights[i]+"), ");
		}
	}
}














