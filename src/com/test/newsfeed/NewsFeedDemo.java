package com.test.newsfeed;

public class NewsFeedDemo {
	public static void main(String[] args) {
		NewsFeeder feeder = new NewsFeeder();
		new MobileApp(feeder, NewsCategory.FINANCE);
		new WebApp(feeder, NewsCategory.SPORTS);
		
		feeder.feedNews("first news",  NewsCategory.FINANCE);
		feeder.feedNews("second news", NewsCategory.SPORTS);
		feeder.feedNews("third news", NewsCategory.EDUCATION);
	}
}
