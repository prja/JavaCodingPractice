package sample.javacode;

public class MultipleInheritanceTest implements X, Y {

	public static void main(String[] args) {

		X x = new MultipleInheritanceTest();
		Y y = new MultipleInheritanceTest();

		x.hello();
		y.hello();
	}

	@Override
	public void hello() {
		System.out.println(" I have no idea which  interface got implemented.");

	}

}

interface X {
	void hello();
}

interface Y {
	void hello();
}