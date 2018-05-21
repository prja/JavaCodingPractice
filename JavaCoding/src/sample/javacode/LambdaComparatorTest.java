package sample.javacode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LambdaComparatorTest {
	String x,y;

	public static void main(String[] args) {
		
		
		
		Thread t;
		 t= new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("In thread main");
			}
		});
		
		
		t= new Thread(()->System.out.println("In thread main using lambda"));
		
		t.start();
		
		
		List<Integer> num= Arrays.asList(1,3,5,6,7,8,9);
		
		//External Iterator
		for (int i = 0; i < num.size(); i++) {
			System.out.println(num.get(i));
		}
		
		
		for(int x: num)
			System.out.println(x);
		
		
		
		//internal itrator
		
		num.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer x) {
				System.out.println(x);
			}
		});
		
		num.forEach((Integer x) -> System.out.println(x));
		
		num.forEach( x -> System.out.println(x));
		
		num.forEach(System.out::println);
		
		
		
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
		
		 List<String> counts = list2.stream().filter(s->s.length()>3).collect(Collectors.toList());
		System.out.println("counts of > 3 char " + counts);
		
		
		// using stream
		list2.stream().sorted(( o1,  o2) -> Integer.compare(o1.length(), o2.length())).forEach(System.out::println);
		
		System.out.println("*---------------------------------------*");
		
		//multiple sorting 
		Comparator <String> compare3=( o1,  o2) -> Integer.compare(o1.length(), o2.length());		
		Comparator <String> compare4=( o1,  o2) -> o1.compareTo(o2);
		
		list2.stream().sorted(compare4.thenComparing(compare3)).forEach(System.out::println);
		
		String name="Prabhu";
		LMB r = (String x) ->{System.out.println(x);};
		r.printme(name);
		
		
		Random rd= new Random();
		 List<int[]> ram = Arrays.asList(rd.ints().limit(10).toArray());
		 
		 
		 MYNAME l=( x)->{System.out.println();};
		 l.myname(name);
		 l.myname(name, name);
		 
		 
		 List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5,25, -1);
		 
		 Optional<Integer> maxx = numbers.stream().reduce(Integer:: max);
		 
		 System.out.println("max== "+maxx.get());
		 
		 Optional<Integer> min = numbers.stream().reduce(Integer:: min);
		 System.out.println("min== "+min.get());
		 
		  Integer ava = (numbers.stream().reduce(Integer::sum ).get())/numbers.size();
		 System.out.println("ava== "+ava);
		 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LambdaComparatorTest other = (LambdaComparatorTest) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
	
	

}

@FunctionalInterface
interface MYNAME{
	void myname(String x);
	default void myname(String x, String y){
		System.out.println("heloo");
	};
}

interface LMB{
	
	void printme(String x);
}