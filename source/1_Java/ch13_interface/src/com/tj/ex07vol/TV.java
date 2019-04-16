package com.tj.ex07vol;
public class TV implements IVolume {
	private final int TV_MAX_VOLUME = 50;
	private int volumeLevel; //new Radio(10); 
	public TV() {volumeLevel=3;}
	public TV(int volumeLevel) {this.volumeLevel=volumeLevel;}
	@Override
	public void volumeDown() {
		volumeLevel--;
		if(volumeLevel<0) {
			volumeLevel=0;
			System.out.println("���� ������ 0�Դϴ�. �� �̻� ����Down �Ұ�");
		}else {
			System.out.println("���� ���� : "+volumeLevel);
		}
	}
	@Override
	public void volumeDown(int level) {
		volumeLevel -= level; //volumeLevel = volumeLevel - level;
		if(volumeLevel<0) {
			volumeLevel=0;
			System.out.println("���� ������ 0�Դϴ�. ���̻� ����Down �Ұ�");
		}else {
			System.out.println("���� ���� : "+volumeLevel);
		}
	}
	@Override
	public void volumeUp() {
		volumeLevel++;
		if(volumeLevel>TV_MAX_VOLUME) {
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("���� �ִ뺼�� 30�Դϴ�. ���̻� ����Up �Ұ�");
		}else {
			System.out.println("���� ���� : "+volumeLevel);
		}
	}
	@Override
	public void volumeUp(int level) {
		volumeLevel += level;
		if(volumeLevel>TV_MAX_VOLUME) {
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("���� �ִ뺼�� 30�Դϴ�. ���̻� ����Up �Ұ�");
		}else {
			System.out.println("���� ���� : "+volumeLevel);
		}
	}
	public int getVolumeLevel() {
		return volumeLevel;
	}
	public void setVolumeLevel(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
}









