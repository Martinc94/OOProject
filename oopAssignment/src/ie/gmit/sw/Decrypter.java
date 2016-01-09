package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class Decrypter implements Runnable{
	private BlockingQueue<Resultable> queue;
	private String cypherText;
	private int key;

	public Decrypter(BlockingQueue<Resultable> queue, String cypherText,int key) {
		super();
		this.queue = queue;
		this.cypherText = cypherText;
		this.key=key;
	}

	public void run() {
		//Create a RailFence object
		RailFence rf = new RailFence();
		
		//RailFence object decrypts cypherText with given key
		String plaintext =rf.decrypt(cypherText, key);
		//System.out.println(plaintext +"  "+key);
		
		//Create a textScorer object and pass it QuadGramMap
		TextScorer ts = new TextScorer(QuadGramMap.QMap);
	
		//create a result
		Resultable r = null;
		
		//initialise the result
		r = new Result(plaintext, key, ts.getScore(plaintext));
			
		//try to add to queue
		try {
			//Inserts the specified element into this queue, waiting if necessary for space to become available
			//System.out.println("Putting on queue");
			
			queue.put(r);
			Runner.incrementFinCount();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}//end catch

	}//end run

}//end decypter
