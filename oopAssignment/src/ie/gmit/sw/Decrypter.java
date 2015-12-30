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
		RailFence rf = new RailFence();
		String plaintext =rf.decrypt(cypherText, key);
		//get the score
		
		///create a map string double from plaintext
		//Map<String, Double> map = null;
		
		TextScorer ts = new TextScorer(QuadGramMap.QMap);
		
		//System.out.println(ts.getScore(plaintext)+ " "+key);
		
		Resultable r = null;//create a result
		
		//initialise result
		r = new Result(plaintext, key, ts.getScore(plaintext));
		
		
		try {
			queue.put(r);
		} catch (InterruptedException e) {
			//System.out.println("error putting on queue");
			e.printStackTrace();
		}
	
		
		//results in queue
		//System.out.println(queue.toString());
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		//System.out.println(plaintext+" "+ key);
	}

}
