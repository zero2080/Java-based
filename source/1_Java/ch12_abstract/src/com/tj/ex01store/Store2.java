package com.tj.ex01store;
/*본사 지침       : 김치찌개-5,000  부대찌개-6,000  비빔밥-6,000 순대국-5,000  공기밥-1,000원
대학가에 매장2호점: 김치찌개-5,000  부대찌개-5,000  비빔밥-5,000 순대국-5,000  공기밥-무료*/
public class Store2 extends HeadQuarterStore {
	@Override
	public void bude() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void bibib() {
		System.out.println("비빔밥 5,000원");
	}
	@Override
	public void gonggibib() {
		System.out.println("공기밥 무료");
	}
}
