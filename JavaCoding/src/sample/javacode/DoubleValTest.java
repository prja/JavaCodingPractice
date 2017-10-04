package sample.javacode;

/**
 * What do the expression 1.0 / 0.0 will return?
 * 
 * 
 * it will not throw ArithmeticExcpetion and return Double.INFINITY.


 * @author prabhun
 *
 */
public class DoubleValTest {

	/**
	 * @return Double.INFINITY.
	 */
	private static Double doubleValTest()
	{
		return 1.0 / 0.0;
	}
	
	public static void main(String[] args) {

		System.out.println(doubleValTest());
	}

}
