package sample.javacode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaComparatorTest {

	public static void main(String[] args) {
		
		// without lambda
		List<String> list1=  Arrays.asList("ab" ,"opqrs","uvxyz123", "cde", "fghi", "jklmn");
		Comparator<String> compare= new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		};
		
		Collections.sort(list1, compare);
		for(String s:list1)
			System.out.println(s);
		
		
		
		System.out.println("*---------------------------------------*");
		
		// with simple lambda
		List<String> list2=  Arrays.asList("ab" ,"aopqrs","auvxyz123", "cde", "fghi", "jklmn");
		Comparator <String> compare2=( o1,  o2) -> Integer.compare(o1.length(), o2.length());
		Collections.sort(list2, compare2); // will be paced  with  stream
		list2.forEach(System.out::println);
		
		// using stream
		list2.stream().sorted(( o1,  o2) -> Integer.compare(o1.length(), o2.length())).forEach(System.out::println);
		
		System.out.println("*---------------------------------------*");
		
		//multiple sorting 
		Comparator <String> compare3=( o1,  o2) -> Integer.compare(o1.length(), o2.length());		
		Comparator <String> compare4=( o1,  o2) -> o1.compareTo(o2);
		
		list2.stream().sorted(compare4.thenComparing(compare3)).forEach(System.out::println);
	}

}
