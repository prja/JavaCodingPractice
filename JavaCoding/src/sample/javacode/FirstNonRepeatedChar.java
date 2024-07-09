package sample.javacode;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstNonRepeatedChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstNonRepeatedChar("aabbccddeffgg"));

	}

	public static Character firstNonRepeatedChar(String str) {
		Map<Character, Integer> charCount = new LinkedHashMap<>();
		for (char c : str.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}
		for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return null;
	}
}
