package com.test.newsfeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Rajeev Krishna Singh
 *
 */
public class NewsFeeder {
//	private List<Channel> channels = new ArrayList<>();
	
	private Map<NewsCategory, List<Channel>> channelMap = new HashMap<>();
	
	private Map<NewsCategory, List<String>> feedsMap = new HashMap<>();
	private List<String> feeds = new ArrayList<>();
	
	/*public List<Channel> getChannels() {
		return channels;
	}*/
	
	public void feedNews(String feed, NewsCategory cat) {
		feeds.add(feed);
		notifyChannels(feed, cat);
	}

	private void notifyChannels(String feed, NewsCategory cat) {
		List<Channel> channels = channelMap.get(cat);
		if(channels != null) {
			for(Channel channel:channels) {
				channel.notifyFeed(feed);
			}
		}
	}
	
	public void attachChannels(Channel channel, NewsCategory cat) {
		List<Channel> channels = channelMap.get(cat);
		if(channels == null) {
			channels = new ArrayList<>();
			channelMap.put(cat, channels);
		}
		channels.add(channel);
	}
}
