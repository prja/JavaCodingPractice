package sample.javacode;

import java.util.Arrays;

public class AnagramCheckString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(areAnagrams("abcd" , "bcda"));
	}
	public static boolean areAnagrams(String str1, String str2) {
	    if (str1.length() != str2.length()) {
	        return false;
	    }
	    char[] charArray1 = str1.toCharArray();
	    char[] charArray2 = str2.toCharArray();
	    Arrays.sort(charArray1);
	    Arrays.sort(charArray2);
	    return Arrays.equals(charArray1, charArray2);
	}
}
