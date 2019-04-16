package com.tj.ex07vol;

public interface IVolume {
	public void volumeDown();
	public void volumeDown(int level);
	public void volumeUp();
	public void volumeUp(int level);
	public default void mute(boolean mute) {// object.mute(true)
		if(mute) {
			System.out.println("무음처리합니다");
		}else {
			System.out.println("무음처리 해제했습니다");
		}
	}
	public static void breakerUp() {
		System.out.println("누적차단기가 내려와서 올렸다");
	}
}
