package sample.javacode;

import java.util.LinkedHashMap;
import java.util.Iterator;

public class MyLRUCache {

	private int capacity;
	private LinkedHashMap<Integer, Integer> map;

	public MyLRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new LinkedHashMap<>();
	}

	public int get(int key) {
		Integer value = this.map.get(key);
		if (value == null) {
			value = -1;
		} else {
			this.put(key, value);
		}
		return value;
	}

	public void put(int key, int value) {
		if (this.map.containsKey(key)) {
			this.map.remove(key);
		} else if (this.map.size() == this.capacity) {

			Iterator<Integer> it = this.map.keySet().iterator();
			it.next();
			it.remove();
		}
		map.put(key, value);
	}

	@Override
	public String toString() {
		return "MyLRUCache [map=" + map + "]";
	}

	public static void main(String[] args) {

		MyLRUCache lruc = new MyLRUCache(5);

		// test
		lruc.put(1, 1);
		lruc.put(2, 2);
		lruc.put(3, 3);
		System.out.println(lruc.toString());

		lruc.get(1);
		System.out.println(lruc.toString());
		lruc.put(4, 4);
		lruc.put(5, 5);
		System.out.println(lruc.toString());
		lruc.get(1);

		lruc.get(5);
		System.out.println(lruc.toString());
		lruc.put(6, 6);
		lruc.put(7, 7);
		lruc.put(8, 8);
		lruc.put(9, 9);
		System.out.println(lruc.toString());

		// MyLRUCache [map={1=1, 2=2, 3=3}]
		// MyLRUCache [map={2=2, 3=3, 1=1}]
		// MyLRUCache [map={2=2, 3=3, 1=1, 4=4, 5=5}]
		// MyLRUCache [map={2=2, 3=3, 4=4, 1=1, 5=5}]
		// MyLRUCache [map={5=5, 6=6, 7=7, 8=8, 9=9}]
		
	}

}