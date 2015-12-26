package ie.gmit.sw;

import java.util.*;
import java.util.concurrent.*;
//priorrity blocking queue
//extract after

public class CypherBreaker {
	private BlockingQueue<Resultable> queue;
	private static final int MAX_QUEUE_SIZE=100;
	private String cypherText;
	
	public CypherBreaker(String cypherText){
		queue = new ArrayBlockingQueue<Resultable>(MAX_QUEUE_SIZE);
		this.cypherText=cypherText;
		init();
		
	}
	
	public void init(){
		//start a load of producers
		//seperate classes
		
		
		for(int i = 2;i<cypherText.length()/2;i++ ){
			System.out.println("creating worker thread "+i);
			new Thread(new Decrypter(queue, cypherText,i)).start();
			
		}
		
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
		
	}

}
