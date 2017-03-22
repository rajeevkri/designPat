package com.test.newsfeed;

public class WebApp extends Channel {

	public WebApp(NewsFeeder feeder) {
		this.feeder = feeder;
		feeder.attachChannels(this);
	}

	@Override
	public void notifyFeed(String feed) {
		System.out.println("Web APP is getting notified with feed = " + feed);
	}

}
