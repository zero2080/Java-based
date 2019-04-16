package com.tj.today;
import java.util.Scanner;
// 영희, 철수, 길동, 영수, 말자 키(180,190,160,170,200))
// String[] names = {"영희","철수", "길동","영수","말자"}
// int[] heights = {180,190,160,170,200}
// 정렬 후
// names = {"길동","영수","영희","철수","말자"}
// heights = {160,170,180,190,200}
// 일반 for문을 이용해서 길동(160), 영수(170), 영희(180), 철수(190), 말자(200)
public class Quiz05 {
	public static void main(String[] args) {
		String[] names = {"영희","철수", "길동","영수","말자"};
		int[] heights = new int[names.length];
		Scanner sc = new Scanner(System.in);
		for(int i=0 ; i<names.length ; i++) {
			System.out.print(names[i]+"의 키는 ?");
			heights[i] = sc.nextInt();
		}// 키 입력 완료 for문
		for(int i=0 ; i<names.length ; i++) {
			System.out.print(names[i]+"("+heights[i]+"), ");
		}
		System.out.println();
		for(int i=0 ; i<heights.length ; i++) {
			for(int j=i+1 ; j<heights.length ; j++) {
				if(heights[i]>heights[j]) {
					// heights[i]와 heights[j]교환
					int temp = heights[i];
					heights[i] = heights[j];
					heights[j] = temp;
					// names[i]와 names[j] 교환
					String tempName = names[i];
					names[i] = names[j];
					names[j] = tempName;
				}// 교환 if
			}//for - j
		}//for-i 정렬완료
		for(int i=0 ; i<names.length ; i++) {
			System.out.print(names[i]+"("+heights[i]+"), ");
		}
	}
}














