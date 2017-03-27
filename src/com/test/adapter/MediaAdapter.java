package com.test.adapter;

public class MediaAdapter implements MediaPlayer {

	AdvancedMediaPlayer advancedMediaPlayer;
	public MediaAdapter(AudioType audioType) {
		switch (audioType) {
		case VLC:
			advancedMediaPlayer = new VlcPlayer();
			break;

		case MP4:
			advancedMediaPlayer = new Mp4Player();
			break;
		default:
			break;
		}
	}

	@Override
	public void play(AudioType audioType, String fileName) {
		switch (audioType) {
		case VLC:
			advancedMediaPlayer.playVlc(fileName);
			break;

		case MP4:
			advancedMediaPlayer.playMp4(fileName);
			break;
		default:
			break;
		}
	}

}
