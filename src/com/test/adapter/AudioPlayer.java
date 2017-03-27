package com.test.adapter;

public class AudioPlayer implements MediaPlayer {
	MediaAdapter mediaAdapter;

	@Override
	public void play(AudioType audioType, String fileName) {

		// inbuilt support to play mp3 music files
		switch (audioType) {
		case MP3:
			System.out.println("Playing mp3 file. Name: " + fileName);
			break;
		case MP4:
		case VLC:
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
			break;

		default:
			System.out.println("Invalid media. " + audioType + " format not supported");
			break;
		}
	}
}
