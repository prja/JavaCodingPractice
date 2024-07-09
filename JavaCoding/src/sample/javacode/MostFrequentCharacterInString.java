package sample.javacode;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class MostFrequentCharacterInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "12345";
		Map<Character, Integer> map = new LinkedHashMap();

		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);

		}
		char x = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
		System.out.println(x);
	}

}
