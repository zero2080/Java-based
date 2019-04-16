package com.tj.ex;
import java.util.Scanner;
// 배열을 이용하여 학생들(영희, 철수, 길동, 영수, 말자)의 키를 입력받고 평균치 출력
// 최단신과 최장친 친구의 이름과 키를 출력
public class Ex06Step2 {
	public static void main(String[] args) {
		String[] arrName = {"영희","철수","길동","영수","말자"};
		int[]    arrHeight = new int[arrName.length];
		Scanner scanner = new Scanner(System.in);
		int totHeight = 0;
		int min=999, max=0; // ★ ★ ★   
		int maxIndex=-1, minIndex=-1; // 최장신과 최단신 index
		for(int idx=0 ; idx<arrName.length ; idx++) {
			System.out.print(arrName[idx]+"의 키는? ");
			arrHeight[idx] = scanner.nextInt();
		}
		scanner.close();
		for(int idx=0 ; idx<arrHeight.length ; idx++) {
			totHeight += arrHeight[idx];
		}
		System.out.println("평균키는 "+totHeight/arrHeight.length);
		for(int idx=0 ; idx<arrHeight.length ; idx++) {
			if(arrHeight[idx]>max) { //max보다 크니?
				max = arrHeight[idx];
				maxIndex = idx;
			}
			if(arrHeight[idx]<min) { // min보다 작니?
				min = arrHeight[idx];
				minIndex = idx;
			}
		}// 최단신과 최장신이 있는 index
		System.out.println("최장신 : "+arrName[maxIndex] +" 키 : "+arrHeight[maxIndex]);
		System.out.println("최단신 : "+arrName[minIndex] +" 키 : "+arrHeight[minIndex]);
	}
}








