package com.test.newsfeed;

public class MobileApp extends Channel {

	NewsCategory category;
	
	public MobileApp(NewsFeeder feeder, NewsCategory category) {
		this.feeder = feeder;
		feeder.attachChannels(this, category);
	}

	@Override
	public void notifyFeed(String feed) {
		System.out.println("Mobile APP is getting notified with feed = " + feed);
	}

	@Override
	public NewsCategory getCategory() {
		return category;
	}
}
