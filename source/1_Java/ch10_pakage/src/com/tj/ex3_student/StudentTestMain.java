package com.tj.ex3_student;
import java.util.Scanner;
public class StudentTestMain {
	public static void main(String[] args) {
		Student[] st = {new Student(20181,"홍길동",22,"컴퓨터공학"),
				new Student(20182,"신길동",23,"정보통신"),
				new Student(20183,"유길동",22,"경영정보"),
				new Student(20184,"김길동",24,"정보통신"),
				new Student(20185,"유길동",20,"경영정보")};
		StudentExpel expel = new StudentExpel();
		for(Student s : st) {//변경전 데이터
			System.out.println(s.infoString());
		}
		// st[0]부터 st[4]까지 나이를 세살씩 증가시켜
		for(Student s : st) {
			s.setAge(s.getAge()+1);//나이 하나 증가시키기
			s.modify(3, String.valueOf(s.getAge()+1));//나이+1을 스트링으로 바꿔
			s.modify(3, s.getAge()+1+"");//나이+1을 스트링으로 바꿔
		}//for
		for(Student s : st) {
			s.print();
		}
		Scanner sc = new Scanner(System.in);
		int hakbun, fn, idx;
		String data;
		while(true) {
			// 1.학번(hakbun) 입력받기(종료:0)
			System.out.print("처리할 학번은 ?(단, 종료는 0)");
			hakbun = sc.nextInt();
			// 2.hakbun==0 이면 break;
			if(hakbun==0) break;
			// 3.입력된 hakbun을 st[0]부터 학번과 조회한다 - 입력한 학번을 찾는다
			for(idx=0 ; idx<st.length ; idx++) {
				if(st[idx].getHakbun()==hakbun) {
					break;//입력한 학번을 찾으면 for문 빠져나감
				}
			}//for
			if(idx==st.length) {
				System.out.println("유효한 학번이 아니야 다시하던지");
				continue;
			}
			// 4.기능번호(fn:1~4)를 입력받아
			System.out.print("원하는 기능은?(1:학번, 2:이름, 3:나이, 4:학과)");
			fn = sc.nextInt();
			if(fn<1 || fn>4) {
				System.out.println("유효한 기능번호가 아니야. 잘해");
			}else {
				// 5.수정될 데이터(data)을 받아
				System.out.print("바뀔 데이터는? ");
				data = sc.next(); //스트링으로 입력받아 data에 할당
				// 6. 수정전 데이터 출력
				System.out.println("수정전 데이터 : "+st[idx].infoString());
				// 7.modify메소드를 이용해서 수정
				st[idx].modify(fn, data);
				// 8.수정 후 데이터 출력
				System.out.println("수정후 데이터 : "+st[idx].infoString());
			}//if
		}// while
		System.out.println("잘가 이때까지 수정된 학생 데이터야");
		for(Student s : st)
			s.print();
	}//main
}//class












