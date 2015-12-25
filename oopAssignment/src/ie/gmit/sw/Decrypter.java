package ie.gmit.sw;

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
		
		Resultable r = null;//create a result
		
		try {
			queue.put(r);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
