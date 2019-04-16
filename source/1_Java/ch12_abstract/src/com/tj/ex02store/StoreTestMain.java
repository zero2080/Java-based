package com.tj.ex02store;
public class StoreTestMain {
	public static void main(String[] args) {
		//HeadQuarterStore hStore = new HeadQuarterStore();
		HeadQuarterStore store1 = new Store1();
		HeadQuarterStore store2 = new Store2();
		HeadQuarterStore store3 = new Store3();
		HeadQuarterStore[] st = {store1, store2, store3};
		for(HeadQuarterStore s : st) {
			System.out.println("* * * "+ s.getName() +" * * * ");
			s.kimchi(); s.bude(); s.bibib(); s.sunde(); s.gonggibib();
		}
	}
}
