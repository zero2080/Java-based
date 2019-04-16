package com.tj.ex07vol;

public class VolumeTestMain {
	public static void main(String[] args) {
		Speaker speaker = new Speaker(10);
		Radio   radio   = new Radio();
		TV      tv      = new TV();
		IVolume[] vol = {speaker, radio, tv};
		IVolume.breakerUp(); 
		for(int idx=0 ; idx<vol.length ; idx++) {
			vol[idx].volumeDown();
			vol[idx].volumeDown(20-(idx*9));
			vol[idx].volumeUp(40);
			vol[idx].volumeUp();
			System.out.println();
			vol[idx].mute(true);
		}
	}
}
