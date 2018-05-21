package sample.javacode;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class ThreadSafeSingleton implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2520539649588405274L;


	private static volatile ThreadSafeSingleton INSTANCE = null;

	private ThreadSafeSingleton() {
		// fix reflection
		if (INSTANCE != null)
			throw new RuntimeException("Invlaid way of instantiation");
	}

	public static ThreadSafeSingleton getInstance() {
		
		// with double check locking
		if (INSTANCE == null) {
			synchronized (ThreadSafeSingleton.class) {
				if (INSTANCE == null)
					return INSTANCE = new ThreadSafeSingleton();
			}
		}

		return INSTANCE;
		
		
		//with Holder patter 
		
		//return Holder.INSTANCE;

	}

	// fix desialization
	private Object readResolve() throws ObjectStreamException {
		return INSTANCE;

	}

	// fix cloning
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return INSTANCE;
	}

	
	
	//holder pattern
	
	static class Holder
	{
		private static final ThreadSafeSingleton INSTANCE= new ThreadSafeSingleton();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
