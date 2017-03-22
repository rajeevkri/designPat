package com.test.dht;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*public class DistributedHashtable implements DHT {
	*//**
	 * The maximum number of keys (nodes/values).
	 *//*
	private static final int N = 1048576;
	private Node<E> predecessor;
	private Map<String, Node<E>> storageData = new LinkedHashMap<>();

	public static ArrayList<String> readConfigFile() throws IOException {
		// read from a JSON
		ArrayList<String> peerList = new ArrayList<String>();

		try {

			
			 * Object obj = parser.parse(new FileReader("config.json"));
			 * 
			 * JSONObject jsonObject = (JSONObject) obj;
			 * 
			 * // loop array JSONArray msg = (JSONArray)
			 * jsonObject.get("peers"); Iterator<?> iterator = msg.iterator();
			 * 
			 * while (iterator.hasNext()) { peerList.add((String)
			 * iterator.next()); }
			 

		} catch (Exception e) {
			System.out.println("Couldn't read from config file");
			e.printStackTrace();
			return null;
		}

		return peerList;
	}

	public static int hash(String key, int numPeers) {
		int sum = 0;
		for (int i = 0; i < key.length(); i++)
			sum += key.charAt(i);

		return sum % numPeers;
	}

	@Override
	public E get(String key) {
		try {
			String k = Key.generate(key, N);
			Node<E> node = lookup(k);
			// System.out.println("get " + node.getStored(k) + " from " + node);
			return node.getStored(k);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void put(String key, E object) {
		try {
			String k = Key.generate(key, N);
			Node<E> node = lookup(k);
			node.addStored(k, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String key) {
		try {
			String k = Key.generate(key, N);
			Node<E> node = lookup(k);
			node.removeStored(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> listAll() {
		Node<E> currentNode = this;
		ArrayList<String> all = new ArrayList<>();
		try {
			do {
				for (E element : currentNode.getValues())
					all.add(element.toString());
				currentNode = currentNode.getSuccessor();
			} while (!this.equals(currentNode));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

	public Node<E> lookup(String key) throws Exception {
		String predKey = predecessor.getKey();

		String[] keys = {};
		keys = storageData.keySet().toArray(keys);
		for (int i = 0; i < (keys.length - 1); i++) {
			String currentKey = keys[i];
			String nextKey = keys[i + 1];
			if (Key.between(key, currentKey, nextKey)) {
				Node<E> currentNode = storageData.get(currentKey);
				Node<E> node = currentNode.getSuccessor();
				return node.lookup(key);
			}
		}
		return storageData.get(keys[keys.length - 1]).getSuccessor().lookup(key);

	}
}*/