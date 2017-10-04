package sample.javacode;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerUsingBlockingQueuue {

	public static void main(String args[]) {

		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();

		Thread prodThread = new Thread(new MyProducer(sharedQueue));

		Thread consThread1 = new Thread(new MyConsumer("Consm_1", sharedQueue));
		Thread consThread2 = new Thread(new MyConsumer("Consm_2", sharedQueue));
		Thread consThread3 = new Thread(new MyConsumer("Consm_3", sharedQueue));

		prodThread.start();
		consThread1.start();
		consThread2.start();
		consThread3.start();
	}

}

// Producer
class MyProducer implements Runnable {

	private final BlockingQueue<Integer> sharedQueue;

	public MyProducer(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				System.out.println("Produced: " + i);
				sharedQueue.put(i);
				Thread.sleep(1000);
				if(i==19)
					i=0;
			} catch (InterruptedException ex) {
				Logger.getLogger(MyProducer.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

}

// Consumer
class MyConsumer implements Runnable {

	private final BlockingQueue<Integer> sharedQueue;
	private String string;

	public MyConsumer(String string, BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
		this.string = string;
	}

	@Override
	public void run() {
		while (true) {
			if(sharedQueue.isEmpty())
			{
				System.out.println("Consumer:  " + this.string + " :  is waiting for next element to be produced---> " );
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
			try {
				System.out.println("Consumed by : " + this.string + " ---> " + sharedQueue.take());
				Thread.sleep(2000);
			} catch (InterruptedException ex) {
				Logger.getLogger(MyConsumer.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		}
	}

}
