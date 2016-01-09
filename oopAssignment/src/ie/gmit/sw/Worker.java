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
		calcTotal();
	//public synchronized void startThreads(){
		for(int i = 2;i<=cypherText.length()/2;i++ ){
			//System.out.println("creating worker thread with key "+i);
			new Thread(new Decrypter(Consumer.queue, cypherText,i)).start();
			
		}//end for
		
		boolean end=false;
		
		while(end==false){
			System.out.println(Runner.totalCount+" tot      fin "+Runner.finCount);
			if(Runner.totalCount==Runner.finCount){
				//Adds Poisoned Result to queue to signal all finished
				AddPoisonResult();
				end=true;
			}//end if
		}//end while
		
	}//end StartThreads	
	
	public void AddPoisonResult(){
		PoisonResult po = new PoisonResult("Poison", -9999, -9999);
		System.out.println("adding poison result");
		try {
			Consumer.queue.put(po);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}//end AddPoisonResult	
	
	public void calcTotal(){
		for(int i = 2;i<=cypherText.length()/2;i++ ){	
			Runner.incrementTotalCount();	
		}//end for
	}

	

}
