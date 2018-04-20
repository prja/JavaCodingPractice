package sample.javacode;
import java.util.ArrayList;
import java.util.Arrays;

public class MyCustomList<E> {
	int size=0;
	int capacity=10;
	Object[] element;
	
	
	public MyCustomList(){
		element= new Object[capacity];
	}
	
	
	public int size()
	{
		return size;
	}
	public void add(E e)
	{
		if(size==capacity)
			ensureCapacity();
		element[size]=e;
		size++;
	}
	
	
	@Override
	public String toString() {
		return "MyCustomList [element=" + Arrays.toString(element) + "]";
	}


	public E get(int index)
	{
		if(index>size)
			throw new ArrayIndexOutOfBoundsException();
		return (E) element[index];
	}
	
	
	private void ensureCapacity()
	{
		element= Arrays.copyOf(element, element.length*2);
	}
	public static void main(String[] args) {
		
		MyCustomList<String> list= new MyCustomList<String>();
		
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("Four");
		System.out.println(list.toString() + list.size());
		
		System.out.println(list.get(0));
		
		
	

	}

}
