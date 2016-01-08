package ie.gmit.sw;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer {
	public static BlockingQueue<Resultable> queue;
	static final int MAX_QUEUE_SIZE=100;
	private String resultText;
	private double resultKey=0;
	private double resultScore=-1000;
	

		//6 consumer takes result from queue and compare
	
	public void consume(){	
		//in loop until poisoned	
		new Thread(new Runnable() {
			public void run() {
				//while(true){
				//while(!queue.isEmpty()){
					//test for poisonResult
					//Resultable t = queue.peek();
					//System.out.println(t.getClass());
					
					//if(t instanceof PoisonResult == true){
						
						//System.out.println("t is a poisonResult");
					//}
					
					//while(t instanceof PoisonResult == false){
					//System.out.println(queue.isEmpty());
					
					if(queue.isEmpty()==false){
						try {
							System.out.println("taking from queue");
							Resultable r = queue.take();
							Runner.consumeCount++;
							
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
