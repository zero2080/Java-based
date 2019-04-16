package com.tj.ex8store;
public class StoreTestMain {
	public static void main(String[] args) {
		//HeadQuarterStore hStore = new HeadQuarterStore();
		HeadQuarterStore store1 = new Store1();
		HeadQuarterStore store2 = new Store2();
		HeadQuarterStore store3 = new Store3();
		HeadQuarterStore[] st = {store1, store2, store3};
		int i=1;
		for(HeadQuarterStore s : st) {
			System.out.println("\n * * * * "+(i++)+"È£Á¡ * * * * * * *");
			s.kimchi();		s.bude();		s.bibib();
			s.sunde();      s.gonggibib();
		}
		/*for(int idx=0 ; idx<st.length ; idx++) {
			System.out.println("\n* * * "+idx +"Á¡ * * *");
			st[idx].kimchi();st[idx].bude();st[idx].bibib();
			st[idx].sunde(); st[idx].gonggibib();
		}*/
	}
}
