package com.tj.ex07vol;

public class Speaker implements IVolume{
	private int volumeLevel;
	public Speaker() {
		volumeLevel = 0;
	}
	public Speaker(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
	@Override
	public void volumeDown() {
		System.out.print("���� ������ "+volumeLevel);
		volumeLevel--;
		System.out.println(", 1��ŭ ������ ���� ������ "+volumeLevel);
	}
	@Override
	public void volumeDown(int level) {
		System.out.print("���� ������ "+volumeLevel);
		volumeLevel -= level;
		System.out.println(", "+level+"��ŭ ������ ���� ������ "+volumeLevel);
	}
	@Override
	public void volumeUp() {
		System.out.print("���� ������ "+volumeLevel);
		volumeLevel++;
		System.out.println(", 1��ŭ �÷��� ���� ������ "+volumeLevel);
	}
	@Override
	public void volumeUp(int level) {
		System.out.print("���� ������ "+volumeLevel);
		volumeLevel += level;
		System.out.println(", "+level+"��ŭ �÷��� ���� ������ "+volumeLevel);
	}
	public int getVolumeLevel() {
		return volumeLevel;
	}
	public void setVolumeLevel(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
}