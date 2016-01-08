package ie.gmit.sw;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {
	//public static int count;

	public static void main(String[] args) {
		//1 get cyphertext
		
		//2 create workers
		
		//3 threads decrypt
		
		//4 threads score the plaintext
		
		//5 thread puts result in queue
		
		//6 consumer takes result from queue and compare
		
		//7 output plaintext
		
		
	
		//STOPTHEMATTHECASTLEGATES
		String cypherText = "SATTMTSLSOETAEEPHHCGTTEA";
		
		//fill quadgramMap
		QuadGramMap.fillMap();	
		
		//System.out.println("before worker");
		//create a worker with threads that decrypts the cyphertext with different keys
		Worker w = new Worker(cypherText);
		
		//creates a new consumer with threads that check score and returns best result
		Consumer c = new Consumer();	
		
		//starts consuming
		//c.consume();
		
		//keep runner alive
		//while(Consumer.queue.isEmpty()==false){
			//c.consume();
			//System.out.println("loop");
		//}
		
		System.out.println("before consumer check");
		while(Consumer.queue.peek()instanceof PoisonResult == true){
			c.consume();
			System.out.println("loop");
		}
		System.out.println("after consumer check");
		
		//output plaintext, key and score of the highest scoring decrypted text
		 //System.out.println("output of plaintext, key and score of the highest scoring decrypted text");
		c.getResults();

	}

}
