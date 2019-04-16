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
			System.out.println("최저 볼륨이 0입니다. 더 이상 볼륨Down 불가");
		}else {
			System.out.println("현재 볼륨 : "+volumeLevel);
		}
	}
	@Override
	public void volumeDown(int level) {
		volumeLevel -= level; //volumeLevel = volumeLevel - level;
		if(volumeLevel<0) {
			volumeLevel=0;
			System.out.println("최저 볼륨이 0입니다. 더이상 볼륨Down 불가");
		}else {
			System.out.println("현재 볼륨 : "+volumeLevel);
		}
	}
	@Override
	public void volumeUp() {
		volumeLevel++;
		if(volumeLevel>TV_MAX_VOLUME) {
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("현재 최대볼륨 30입니다. 더이상 볼륨Up 불가");
		}else {
			System.out.println("현재 볼륨 : "+volumeLevel);
		}
	}
	@Override
	public void volumeUp(int level) {
		volumeLevel += level;
		if(volumeLevel>TV_MAX_VOLUME) {
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("현재 최대볼륨 30입니다. 더이상 볼륨Up 불가");
		}else {
			System.out.println("현재 볼륨 : "+volumeLevel);
		}
	}
	public int getVolumeLevel() {
		return volumeLevel;
	}
	public void setVolumeLevel(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
}









