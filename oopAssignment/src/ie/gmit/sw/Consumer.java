package ie.gmit.sw;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer {
	public static BlockingQueue<Resultable> queue;
	static final int MAX_QUEUE_SIZE=10000;
	private String resultText="default";
	private double resultKey=-1000;
	private double resultScore=-1000;
	
	
	public Consumer() {
		//starts threads
		startConsumer();
		System.out.println("started consumer");
	}
	
	private void startConsumer() {
		//if(queue.isEmpty()!=true){
		//Resultable test= queue.peek();
		//System.out.println(test.getKey());
		//System.out.println(test instanceof PoisonResult);
		//while(queue.peek()instanceof PoisonResult == false){
			//System.out.println(queue.peek()instanceof PoisonResult);
			//consume();
		//}//end while
		//}		
		/*while (Runner.getFinished()==false) {
			consume();
			//System.out.println("Consume "+Runner.finished);
		}*/
		
		for (int i = 0; i < Runner.totalCount; i++) {
			consume();
		}
		
		
	}//end startConsumer

	public void consume(){	
		//in loop until poisoned	
		new Thread(new Runnable() {
			public void run() {
					//if(queue.isEmpty()==false){
					if(Runner.getFinished()==false){
						try {
							//System.out.println("taking from queue");
							Resultable r = queue.take();
							//System.out.println("Took From Queue");
							Runner.incrementConsumeCount();
							//System.out.println(r.getScore()+"     "+r.getKey()+"       "+r.getPlaintext());
							
							if(r instanceof PoisonResult == true)
							{
								System.out.println("POISONED");
								Runner.setFinished();
							}
							else{
								//System.out.println(r.getScore()+"     "+r.getKey()+"       "+r.getPlaintext());
								
								if(r.getScore()>resultScore){
									resultScore=r.getScore();
									resultKey=r.getKey();
									resultText=r.getPlaintext();
									
									//System.out.println("new score");
									//System.out.println(r.getScore()+"     "+r.getKey()+"       "+r.getPlaintext());
								}//if		
							}
						
							
							
							//save if better than result score
							/*if(r.getScore()>resultScore){
								resultScore=r.getScore();
								resultKey=r.getKey();
								resultText=r.getPlaintext();
							}//if	*/					
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}//end if 
					
				}
		}).start();
		
		
	}
	
	public void getResults(){
		System.out.println("\nPlaintext is "+resultText);
		System.out.printf("Key is %.0f\n",resultKey);
		System.out.printf("best Score is %.2f",resultScore);
		
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
