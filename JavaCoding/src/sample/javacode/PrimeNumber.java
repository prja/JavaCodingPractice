package sample.javacode;
import java.util.stream.*;
public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Prime num  : 0-100 ");
		for(int i=0; i<100; i++)
			if(isPrime(i))
			System.out.println(i);
		
		
		System.out.println("Prime num  : 0-100  java8");
		for(int i=0; i<100; i++)
			if(isPrimeJava8(i))
			System.out.println(i);
		
	}

	
	private static boolean isPrime(int num)
	{
		
		if(num<1)
			return false;
		
		for(int i=2; i<num; i++)
			if(num%i==0) return false;
		return true;
	}
	
	private static boolean isPrimeJava8(int num)
	{
		return IntStream.rangeClosed(2,  num/2).noneMatch(x-> num%x==0);
	}
}
