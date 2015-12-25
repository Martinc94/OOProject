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
		
		for(int i = 2;i<cypherText.length()/2;i++ )
		{
			new Thread(new Decrypter(queue, cypherText,i)).start();
			
		}
		
		new Thread(new Runnable() {
			public void run() {
				while(!queue.isEmpty()){
					
					try {
						Resultable r = queue.take();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//do something
				}
			}
		});
		
	}

}
