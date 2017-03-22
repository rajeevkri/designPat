package com.test.newsfeed;

public class MobileApp extends Channel {

	public MobileApp(NewsFeeder feeder) {
		this.feeder = feeder;
		feeder.attachChannels(this);
	}

	@Override
	public void notifyFeed(String feed) {
	}

}
