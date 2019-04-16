package com.tj.ex02;
/*a제품 : DMB송수신불가, 3G, TV리모콘 미탑재, 
b제품 : DMB송수신가능, LTE, TV리모콘 탑재, 
c제품 : DMB송수신가능, LTE, TV리모콘 미탑재*/
public interface IAcor {
	public void dmbReceive();
	public void lte();
	public void tvremoteControl();
}