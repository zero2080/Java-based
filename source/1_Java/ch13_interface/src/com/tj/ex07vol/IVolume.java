package com.tj.ex07vol;

public interface IVolume {
	public void volumeDown();
	public void volumeDown(int level);
	public void volumeUp();
	public void volumeUp(int level);
	public default void mute(boolean mute) {// object.mute(true)
		if(mute) {
			System.out.println("����ó���մϴ�");
		}else {
			System.out.println("����ó�� �����߽��ϴ�");
		}
	}
	public static void breakerUp() {
		System.out.println("�������ܱⰡ �����ͼ� �÷ȴ�");
	}
}
