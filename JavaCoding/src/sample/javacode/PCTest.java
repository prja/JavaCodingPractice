package sample.javacode;

import java.util.LinkedList;
import java.util.Queue;

public class PCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue q = new LinkedList();

		Thread pt = new Thread(new P(q, "Producer"));
		Thread ct = new Thread(new C(q, "consumer"));
		
		Thread ct1 = new Thread(new C(q, "consumer1"));
		Thread ct2 = new Thread(new C(q, "consumer2"));
		pt.start();
		ct.start();ct1.start();ct2.start();

	}

}

class P implements Runnable {
	private Queue q;
	private String str;

	public P(Queue q, String string) {
		this.q = q;
		this.str = string;
	}

	@Override
	public void run() {

		while (true) {

			synchronized (q) {
				while (!q.isEmpty()) {
					
						try {
							q.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
			
			
				synchronized (q) {
					for(int x=0; x<10; x++)
					{
					this.q.add(x);
					System.out.println("Produced : "+ x);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					}
					q.notifyAll();
				}
			
			
		}

	}

}

class C implements Runnable {

	private Queue q;
	private String str;

	public C(Queue q, String string) {
		this.q = q;
		this.str = string;
	}

	@Override
	public void run() {
		while (true) {

			
			while (q.isEmpty()) {
				synchronized (q) {
					try {
						q.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		
		
			synchronized (q) {
				System.out.println("consumed  by : "+this.str +"           = "+ q.poll());
				q.notifyAll();
			}
		
		
	}
	}

}