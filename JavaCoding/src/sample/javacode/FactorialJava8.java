package sample.javacode;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FactorialJava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(factorialStreams(5));
	}
	public static long factorialStreams( int n )
	{
	    return IntStream.rangeClosed( 1, n )
	                     .reduce(1, ( int a, int b ) -> a * b);
	}
}
