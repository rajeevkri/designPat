package com.test.newsfeed;

import java.util.ArrayList;
import java.util.List;

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

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
		
		intList.add(2);
		intList.add(0, 1);
		System.out.println(intList);
	}

	@Override
	public NewsCategory getCategory() {
		return category;
	}
}
