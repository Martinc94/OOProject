package ie.gmit.sw;

import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;

public class Worker {
	private String cypherText;
	
	public Worker(String cypherText){
		Consumer.queue = new ArrayBlockingQueue<Resultable>(Consumer.MAX_QUEUE_SIZE);
		this.cypherText=cypherText;
		//starts threads
		startThreads();
	}
	
	public void startThreads(){
		for(int i = 2;i<=cypherText.length()/2;i++ ){
			//System.out.println("creating worker thread with key "+i);
			new Thread(new Decrypter(Consumer.queue, cypherText,i)).start();	
		}//end for
		
	}//end StartThreads	

}
