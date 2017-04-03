package com.test.newsfeed;

/**
 * 
 * @author Rajeev Krishna Singh
 *
 */
public abstract class Channel {
	NewsFeeder feeder;

	public abstract void notifyFeed(String feed);
	
	public abstract NewsCategory getCategory();
}
