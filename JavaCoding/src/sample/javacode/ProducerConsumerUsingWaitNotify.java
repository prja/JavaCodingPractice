package sample.javacode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerUsingWaitNotify {

	public static void main(String args[]) {

		Queue<Integer> sharedQueue = new LinkedList<Integer>();
		

		int SIZE=20;
		Thread prodThread = new Thread(new MyProducer2(sharedQueue,SIZE));

		Thread consThread1 = new Thread(new MyConsumer2("Consm_1", sharedQueue,SIZE));
		Thread consThread2 = new Thread(new MyConsumer2("Consm_2", sharedQueue,SIZE));
		Thread consThread3 = new Thread(new MyConsumer2("Consm_3", sharedQueue,SIZE));

		prodThread.start();
		consThread1.start();
		consThread2.start();
		consThread3.start();
	}

}

// Producer
class MyProducer2 implements Runnable {

	private final Queue<Integer> sharedQueue;
	int SIZE;
	public MyProducer2(Queue<Integer> sharedQueue, int  SIZE) {
		this.sharedQueue = sharedQueue;
		this.SIZE=SIZE;
	}

	@Override
	public void run() {

		
			while (sharedQueue.size()==SIZE) {
				synchronized (sharedQueue) {
				try {
					sharedQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (sharedQueue) {
			for (int i = 0; i < 20; i++) {
				try {
					System.out.println("Produced: " + i);
					sharedQueue.add(i);
					Thread.sleep(1000);
					if (i == 19)
						i = 0;
					sharedQueue.notifyAll();
				} catch (InterruptedException ex) {
					Logger.getLogger(MyProducer2.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			

		}

	}

}

// Consumer
class MyConsumer2 implements Runnable {

	private final Queue<Integer> sharedQueue;
	private String string;
	private int SIZE;

	public MyConsumer2(String string, Queue<Integer> sharedQueue, int sIZE) {
		this.sharedQueue = sharedQueue;
		this.string = string;
		this.SIZE=sIZE;
	}

	@Override
	public void run() {
		while (true) {

			synchronized (sharedQueue) {
				while (sharedQueue.isEmpty()) {
					try {
						System.out.println(
								"Consumer:  " + this.string + " :  is waiting for next element to be produced---> ");
						sharedQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				synchronized (sharedQueue) {
					try {
						System.out.println("Consumed by : " + this.string + " ---> " + sharedQueue.poll());
						sharedQueue.notifyAll();
						Thread.sleep(2000);
					} catch (InterruptedException ex) {
						Logger.getLogger(MyConsumer2.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		}
	}

}
