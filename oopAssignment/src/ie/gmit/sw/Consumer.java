package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class Consumer {
	public static BlockingQueue<Resultable> queue;
	static final int MAX_QUEUE_SIZE=100;

	public static void main(String[] args) {
		//6 consumer takes result from queue and compare

	}
	
	/*
	 //consume results
	 new Thread(new Runnable() {
			public void run() {
				System.out.println("starting to run");
				while(!queue.isEmpty()){					
					try {
						System.out.println("taking from queue");
						Resultable r = queue.take();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//do something
				}
			}
		}); 
	  
	  
	 
	  
	 */

}
