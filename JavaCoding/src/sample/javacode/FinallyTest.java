package sample.javacode;

/**
 * What will happen if you put return statement or System.exit () on try or
 * catch block? Will finally block execute?
 * 
 * @author prabhun
 *
 */
public class FinallyTest {

	/**
	 * finally block will run
	 */
	private static String finallyTest1() {
		System.out.println("finallyTest1");
		String str = "";
		try {
			str = "return from try block";
		} finally {
			str = "return from fillay block";
		}
		return str;
	}

	/**
	 * finally block will run
	 */
	private static String finallyTest2() {
		System.out.println("finallyTest2");
		try {
			return "return from try block";
		} finally {
			return "return from fillay block";
		}
	}

	/**
	 * finally block will run
	 */
	private static void finallyTest3() {
		System.out.println("finallyTest3");
		try {

			int x = 1 / 0;
			System.out.println("inside try block");
		} catch (Exception e) {
			System.out.println("inside catch block");
		} finally {
			System.out.println("inside finally block");
		}

	}

	/**
	 * Only try block will run not finally
	 */
	private static void finallyTest4() {

		System.out.println("finallyTest4");
		try {
			System.out.println("inside try block");
			System.exit(0);
		} finally {
			System.out.println("inside finally block");
		}
	}

	public static void main(String[] args) {

		System.out.println(finallyTest1());
		System.out.println("******************************************************************");
		System.out.println(finallyTest2());
		System.out.println("******************************************************************");
		finallyTest3();
		System.out.println("******************************************************************");
		finallyTest4();

	}

}
