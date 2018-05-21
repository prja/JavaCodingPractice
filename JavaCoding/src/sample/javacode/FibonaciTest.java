package sample.javacode;
import java.util.stream.*;

public class FibonaciTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//printFiboSerise(10);
		//printFactorial(3);
		isPolindrom("abcd");
		fibJava8(2);
		factJava8(5);
	}

private static void factJava8(int num)
{
	System.out.println("Factorial "+(IntStream.rangeClosed(1, num).reduce(1,(int a, int b)->a*b)));
}
	
	private static void fibJava8(int num)
	{
		Stream.iterate(new long[]{1,1}, p->new long[]{p[1],p[0]+p[1]}).limit(num).forEach(p->{System.out.println(p[0]);});
	}
	
	private static void printFiboSerise(int length)
	{
		int fistElement=0, secondelemnt=1, nextElement=0;
		if(length<=0)
			System.out.println("Please enter valid  lenth " );

		if(length>0)
			System.out.print(fistElement  );
		if(length>1)
			System.out.print( " "+ secondelemnt );


		for (int i = 2; i < length; ++i) {
			nextElement=fistElement+secondelemnt;
			System.out.print( " "+nextElement);
			fistElement=secondelemnt;
			secondelemnt=nextElement;
		}
	}
	
	
	
	private static void printFactorial(int val)
	{
		int fact= 1;
		if(val==0 || val==1)
			System.out.println(fact);
		
		for (int i = 1; i <=val; i++) {
			fact*=i;
			
			
		}
		System.out.println(fact);
		
	}
	
	private static void isPolindrom(String str)
	{
		
		String rev= "";
		int size= str.length()-1;
		for (int i = size; i >=0; i--) {
			rev+=str.charAt(i);
			
		}
		System.out.println("str : "+str);
		System.out.println(" rev : "+rev);
		System.out.println(" is polindrom : "+rev.equals(str));
	}

}

