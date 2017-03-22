package com.test.dht;

import java.util.List;

public interface DHT<V> {
	/**
	 * Get an object that is mapped to the key.
	 * @param key
	 * @return the mapped object.
	 */
	public V get(String key);
	
	/**
	 * Put a new object in the DHT, the key can be any string.
	 * @param key - A unique key
	 * @param element - The object to associate with the key.
	 */
	public void put(String key, V element);
	
	/**
	 * Remove a key/object mapping if it exists.
	 * @param key
	 */
	public void remove(String key);
	
	/**
	 * List the String-representations of all values in the map.
	 * @return a list of human-readable strings..
	 */
	public List<String> listAll();
 }