package com.test.newsfeed;

public class NewsFeedDemo {
	public static void main(String[] args) {
		NewsFeeder feeder = new NewsFeeder();
		new MobileApp(feeder);
		new WebApp(feeder);
		
		feeder.feedNews("first news");
		feeder.feedNews("second news");
		feeder.feedNews("third news");
	}
}
