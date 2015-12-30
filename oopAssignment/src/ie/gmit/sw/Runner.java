package ie.gmit.sw;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {

	public static void main(String[] args) {
		//1 get cyphertext
		
		//2 create workers
		
		//3 threads decrypt
		
		//4 threads score the plaintext
		
		//5 thread puts result in queue
		
		//6 consumer takes result from queue and compare
		
		//7 output plaintext
		
		
		//String cypherText = "STOPTHEMATTHECASTLEGATES";
		String cypherText = "SATTMTSLSOETAEEPHHCGTTEA";
		
		//fill quadgramMap
		QuadGramMap.fillMap();	
		
		//creates worker threads that decrypts the cyphertext with different keys
		Worker w = new Worker(cypherText);
		
		//
		
		
		
		
		
		 System.out.println("end");

	}

}
