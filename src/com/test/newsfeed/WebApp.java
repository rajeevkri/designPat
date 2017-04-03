package com.test.newsfeed;

public class WebApp extends Channel {

	NewsCategory category;

	public WebApp(NewsFeeder feeder, NewsCategory category) {
		this.feeder = feeder;
		this.category = category;
		feeder.attachChannels(this,category);
	}

	public NewsCategory getCategory() {
		return category;
	}

	@Override
	public void notifyFeed(String feed) {
		System.out.println("Web APP is getting notified with feed = " + feed);
	}

}
