package com.tj.ex02;
/*a��ǰ : DMB�ۼ��źҰ�, 3G, TV������ ��ž��, 
b��ǰ : DMB�ۼ��Ű���, LTE, TV������ ž��, 
c��ǰ : DMB�ۼ��Ű���, LTE, TV������ ��ž��*/
public interface IAcor {
	public void dmbReceive();
	public void lte();
	public void tvremoteControl();
}