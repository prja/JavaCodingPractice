package sample.javacode;

public class SwapNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x=10;
		int y=20;
		
		//add
		
		System.out.println("before swap  x = "+ x+ " y= "+y);
		
		x=x+y;
		y=x-y;
		x=x-y;
		
		System.out.println("after swap  x = "+ x+ " y= "+y);
		
		
		// binary operator
		
		x=x^y;
		y=x^y;
		x=x^y;
		
		System.out.println("after swap  x = "+ x+ " y= "+y);
		
		
		//Divide and multiply
		
		x=x*y;
		y=x/y;
		x=x/y;
		
		System.out.println("after swap  x = "+ x+ " y= "+y);
		
		
	}

	
	
}
