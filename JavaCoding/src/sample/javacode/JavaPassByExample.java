package sample.javacode;

public class JavaPassByExample {
	
	private static void swap(Integer a, Integer b)
	{
		Integer temp=a;
		a=b;
		b=temp;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer x= 10;
		Integer y= 20;
		swap(x, y);
		
		System.out.println("x= "+ x + "  y= "+y) ;
	}

}
