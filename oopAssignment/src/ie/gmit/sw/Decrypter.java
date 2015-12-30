package ie.gmit.sw;

import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class Decrypter implements Runnable{//Producer
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
		
		//Create a textScorer object and pass it QuadGramMap
		TextScorer ts = new TextScorer(QuadGramMap.QMap);
		
		//System.out.println(ts.getScore(plaintext)+ " "+key);
		
		//create a result
		Resultable r = null;
		
		//initialise the result
		r = new Result(plaintext, key, ts.getScore(plaintext));
		
		//try to add to queue
		try {
			Consumer.queue.put(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	    Runner.count++;
	    System.out.println("                               "+Runner.count);
		
		//results in queue
		//System.out.println(queue.toString());
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		//System.out.println(plaintext+" "+ key);
	}

}
