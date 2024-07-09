package documents;

import java.util.*;
import java.util.stream.Stream;
import java.io.*;

public class Main {
	private static final MyLRUCache cache = new MyLRUCache(5);
	private static final String EMPTY = "EMPTY";
	static StringBuilder sb = new StringBuilder();

	public static String ArrayChallenge(String[] string) {

		for (String string2 : string) {
			String[] atr = string2.split("");
			// code goes here
			for (String keyValue : atr) {
				cache.put(keyValue, keyValue);
			}
			for (Map.Entry<String, String> entry : cache.getMap().entrySet()) {
				sb.append(entry.getKey() + "-");
			}
		}

		String fs = sb.toString();
		if (fs != null && !fs.isEmpty()) {
			int index = fs.lastIndexOf("-");
			fs = fs.substring(0, index);
			return fs;
		} else {
			return EMPTY;
		}

	}

	public static void main(String[] args) {
		// keep this function call here
		Scanner s = new Scanner(System.in);
  // String [] ss=s.nextLine().split("");
  String [] ss=new String[] {"A", "B", "A", "C", "A", "B"};
		System.out.print(ArrayChallenge(ss));
	}

}

class MyLRUCache {

	private int capacity;
	private LinkedHashMap<String, String> map;

	public LinkedHashMap<String, String> getMap() {
		return map;
	}

	public void setMap(LinkedHashMap<String, String> map) {
		this.map = map;
	}

	public MyLRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new LinkedHashMap<>();
	}

	public String get(String key) {
		String value = this.map.get(key);
		if (value == null) {
			value = "";
		} else {
			this.put(key, value);
		}
		return value;
	}

	public void put(String key, String value) {
		if (this.map.containsKey(key)) {
			this.map.remove(key);
		} else if (this.map.size() == this.capacity) {

			Iterator<String> it = this.map.keySet().iterator();
			it.next();
			it.remove();
		}
		map.put(key, value);
	}
}