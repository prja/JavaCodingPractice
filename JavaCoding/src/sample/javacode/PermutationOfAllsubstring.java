package sample.javacode;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfAllsubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(permute("abcd"));
	}

	public static List<String> permute(String str) {
		List<String> result = new ArrayList<>();
		permuteHelper("", str, result);
		return result;
	}

	private static void permuteHelper(String prefix, String str, List<String> result) {
		int n = str.length();
		if (n == 0) {
			result.add(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				permuteHelper(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1), result);
			}
		}
	}

}
