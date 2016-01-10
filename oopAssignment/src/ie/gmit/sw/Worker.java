package ie.gmit.sw;

import java.util.concurrent.ArrayBlockingQueue;

/** Responsible for Creating and managing threads to decrypt text */
public class Worker {
	/** String Containing cypertext passed to worker */
	private String cypherText;

	public Worker(String cypherText){
		Consumer.queue = new ArrayBlockingQueue<Resultable>(Consumer.MAX_QUEUE_SIZE);
		this.cypherText=cypherText;
		//calculates total amount of threads neaded
		calcTotal();
		//starts threads
		startThreads();
	}
	
	/** Method that Creates threads to decrypt text, Adds a poisonResult when finished all threads */
	public void startThreads(){
		for(int i = 2;i<=cypherText.length()/2;i++ ){
			//System.out.println("creating worker thread with key "+i);
			new Thread(new Decrypter(Consumer.queue, cypherText,i)).start();
			
		}//end for
		
		boolean end=false;
		
		while(end==false){
			if(Runner.getTotalCount()==Runner.getFinCount()){
				//Adds Poisoned Result to queue to signal all finished
				AddPoisonResult();
				end=true;
			}//end if
		}//end while
		
	}//end StartThreads	
	
	/** Adds a poisonResult to queue when called */
	public void AddPoisonResult(){
		PoisonResult po = new PoisonResult("Poison", -9999, -9999);
		//System.out.println("adding poison result");
		try {
			Consumer.queue.put(po);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}//end AddPoisonResult	
	/** Calculates total number of threads needed to break cypher */
	public void calcTotal(){
		for(int i = 2;i<=cypherText.length()/2;i++ ){	
			Runner.incrementTotalCount();	
		}//end for
	}//end calcTotal

}//end worker
