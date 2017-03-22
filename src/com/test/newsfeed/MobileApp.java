package com.test.newsfeed;

public class MobileApp extends Channel {

	public MobileApp(NewsFeeder feeder) {
		this.feeder = feeder;
		feeder.attachChannels(this);
	}

	@Override
	public void notifyFeed(String feed) {
		System.out.println("Mobile APP is getting notified with feed = " + feed);
	}

}
