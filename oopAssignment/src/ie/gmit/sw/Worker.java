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
	
	//public void startThreads(){
	public synchronized void startThreads(){
		for(int i = 2;i<=cypherText.length()/2;i++ ){
			System.out.println("creating worker thread with key "+i);
			Runner.count= 1;
			new Thread(new Decrypter(Consumer.queue, cypherText,i)).start();
			
		}//end for
		
		//loops until all threads finished
		while(Runner.count!=(cypherText.length()/2)){
			System.out.println("Looping with count "+ Runner.count);
		}//end while
		
		//System.out.println("adding poison result");
		//Adds Poisoned Result to queue to signal all finished
		//AddPoisonResult();
		
	}//end StartThreads	
	
	public void AddPoisonResult(){
		PoisonResult po = new PoisonResult(" ", 99, 99);
		
		try {
			Consumer.queue.put(po);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//end AddPoisonResult	

}
