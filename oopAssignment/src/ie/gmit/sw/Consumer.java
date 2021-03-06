package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

/** Class that Contains a queue of resultable objects and takes resultable off queue and scores them */
public class Consumer {
	/** BlockingQueue that stores resultable objects */
	public static BlockingQueue<Resultable> queue;
	static final int MAX_QUEUE_SIZE=10000;
	private String resultText="default";
	private double resultKey=-1000;
	private double resultScore=-1000;
	private boolean finished;
		
	public Consumer() {
		//starts threads
		startConsumer();
	}
	/** Method that creates a loop that consumes results off queue */
	private void startConsumer() {
		for (int i = 1; i < Runner.totalCount; i++) {
			consume();
		}	
		
	}//end startConsumer
	
	/** Method that consumes results off queue */
	public void consume(){	
					if(finished==false){
						try {
							Resultable r = queue.take();
							//System.out.println("Took From Queue");						
							if(r instanceof PoisonResult == true)
							{
								//Poisoned Object Found							
								finished=true;
								//System.out.println("POISONED");
							}
							else{
															
								if(r.getScore()>resultScore){
									resultScore=r.getScore();
									resultKey=r.getKey();
									resultText=r.getPlaintext();
								}//if		
							}//end ifNotPoison				
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}//end if 	
	}//end consume
	
	/** Method that Prints the highest scoring result */
	public void getResults(){
		System.out.println("\nPlaintext is "+resultText);
		System.out.printf("Key is %.0f\n",resultKey);
		System.out.printf("best Score is %.2f",resultScore);
	}//end getResults
}