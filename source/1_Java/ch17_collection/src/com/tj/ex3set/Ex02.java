package com.tj.ex3set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
// 로또번호 6개 뽑기
public class Ex02 {
	public static void main(String[] args) {
		//int[] lotto = new int[6];
		HashSet<Integer> lotto = new HashSet<Integer>();
		Random ran = new Random();
		while(lotto.size()<6) {
			lotto.add(ran.nextInt(45)+1);
		}
		Iterator<Integer> iterator = lotto.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + "   ");
		}
	}
}
