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
		System.out.print("원래 볼륨은 "+volumeLevel);
		volumeLevel--;
		System.out.println(", 1만큼 낮춰진 현재 볼륨은 "+volumeLevel);
	}
	@Override
	public void volumeDown(int level) {
		System.out.print("원래 볼륨은 "+volumeLevel);
		volumeLevel -= level;
		System.out.println(", "+level+"만큼 낮춰진 현재 볼륨은 "+volumeLevel);
	}
	@Override
	public void volumeUp() {
		System.out.print("원래 볼륨은 "+volumeLevel);
		volumeLevel++;
		System.out.println(", 1만큼 올려진 현재 볼륨은 "+volumeLevel);
	}
	@Override
	public void volumeUp(int level) {
		System.out.print("원래 볼륨은 "+volumeLevel);
		volumeLevel += level;
		System.out.println(", "+level+"만큼 올려진 현재 볼륨은 "+volumeLevel);
	}
	public int getVolumeLevel() {
		return volumeLevel;
	}
	public void setVolumeLevel(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
}