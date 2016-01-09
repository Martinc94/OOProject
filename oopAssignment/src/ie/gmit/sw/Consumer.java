package ie.gmit.sw;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer {
	public static BlockingQueue<Resultable> queue;
	static final int MAX_QUEUE_SIZE=100;
	private String resultText;
	private double resultKey=0;
	private double resultScore=-1000;
	
	
	public Consumer() {
		//starts threads
		startConsumer();
		System.out.println("start consumer");
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
		
		while (Runner.finished==false) {
			consume();
			//System.out.println(Runner.finished);
		}
		System.out.println("done");
		
	}//end startConsumer

	public void consume(){	
		//in loop until poisoned	
		new Thread(new Runnable() {
			public void run() {
					
					//if(queue.isEmpty()==false){
					if(Runner.finished==false){
						try {
							System.out.println("taking from queue");
							Resultable r = queue.take();
							Runner.incrementConsumeCount();
							
							if(r instanceof PoisonResult == true)
							{
								System.out.println("POISONED");
								Runner.finished=true;
							}
							
							
							//save if better than 0
							if(r.getScore()>resultScore){
								resultScore=r.getScore();
								resultKey=r.getKey();
								resultText=r.getPlaintext();
							}//if						
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
		}).start();
		
		
	}
	
	public void getResults(){
		System.out.println("Plaintext is "+resultText);
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
