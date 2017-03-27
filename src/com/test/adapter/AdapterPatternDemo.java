package com.test.adapter;

public class AdapterPatternDemo {

	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();

	      audioPlayer.play(AudioType.MP3, "beyond the horizon.mp3");
	      audioPlayer.play(AudioType.MP4, "alone.mp4");
	      audioPlayer.play(AudioType.VLC, "far far away.vlc");
	      audioPlayer.play(AudioType.AVI, "mind me.avi");
	}
}
