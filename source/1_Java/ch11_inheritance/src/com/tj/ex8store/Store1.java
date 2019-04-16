package com.tj.ex8store;
/*본사 지침       : 김치찌개-5,000  부대찌개-6,000  비빔밥-6,000 순대국-5,000  공기밥-1,000원
주택가에 매장1호점: 김치찌개-4,500  부대찌개-5,000  비빔밥-6,000 순대국-안팔아    공기밥-1,000원*/
public class Store1 extends HeadQuarterStore{
	@Override
	public void kimchi() {
		System.out.println("김치찌개 4,500원");
	}
	@Override
	public void bude() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국은 안 팔아요");
	}
}
