package ie.gmit.sw;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Consumer {
	public static BlockingQueue<Resultable> queue;
	static final int MAX_QUEUE_SIZE=100;
	private String resultText;
	private double resultKey=0;
	private double resultScore=0;
	
	

		//6 consumer takes result from queue and compare
	
	public void consume(){
		
		System.out.println("In consumer ");
		
		//in loop until poisoned
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("starting threads");
				
				while(true){
				//while(!queue.isEmpty()){
					//test for poisonResult
					Resultable t = queue.peek();
					System.out.println(t.getClass());
					
					if(t instanceof PoisonResult == true){
						
						System.out.println("t is a poisonResult");
					}
					
					while(t instanceof PoisonResult == false){
						try {
							//System.out.println("taking from queue");
							Resultable r = queue.take();
							
							//save if better than 0
							if(r.getScore()>resultScore){
								resultScore=r.getScore();
								resultKey=r.getKey();
								resultText=r.getPlaintext();
							}//if
							
							//System.out.println(r.getKey()+" "+r.getScore());
							
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}//end while
					//do something
				}
			}
		}).start();
		
		
	}
	
	public void getResults(){
		System.out.println("Plaintext is "+resultText);
		System.out.println("Key is "+resultKey);
		System.out.println("best Score is "+resultScore);
		
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
