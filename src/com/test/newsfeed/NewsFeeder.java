package com.test.newsfeed;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Rajeev Krishna Singh
 *
 */
public class NewsFeeder {
	private List<Channel> channels = new ArrayList<>();
	
	private List<String> feeds = new ArrayList<>();
	
	public List<Channel> getChannels() {
		return channels;
	}
	
	public void feedNews(String feed) {
		feeds.add(feed);
		notifyChannels(feed);
	}

	private void notifyChannels(String feed) {
		for(Channel channel:channels) {
			channel.notifyFeed(feed);
		}
	}
	
	public void attachChannels(Channel channel) {
		channels.add(channel);
	}
}
