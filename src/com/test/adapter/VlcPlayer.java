package com.test.adapter;

public class VlcPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		System.out.println("playing vlc player");
	}

	@Override
	public void playMp4(String fileName) {
		// do nothing
	}

}
