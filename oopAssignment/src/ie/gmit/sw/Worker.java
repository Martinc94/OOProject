package ie.gmit.sw;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Worker {
	private String cypherText;
	
	public Worker(String cypherText){
		Consumer.queue = new ArrayBlockingQueue<Resultable>(Consumer.MAX_QUEUE_SIZE);
		this.cypherText=cypherText;
		//init();
	}
	
	
	

}
