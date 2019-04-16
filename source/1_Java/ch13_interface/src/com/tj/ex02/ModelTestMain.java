package com.tj.ex02;

public class ModelTestMain {
	public static void main(String[] args) {
		AModel aModel = new AModel();
		BModel bModel = new BModel();
		CModel cModel = new CModel();
		IAcor[] phone = {aModel, bModel, cModel};
		for(int idx=0 ; idx<phone.length ; idx++) {
			phone[idx].dmbReceive();
			phone[idx].lte();
			phone[idx].tvremoteControl();
			System.out.println();
		}
	}
}
