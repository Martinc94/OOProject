package ie.gmit.sw;

import java.awt.Menu;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Scanner;

public class Runner {
	//public static int count;
	static Scanner console = new Scanner(System.in);
	public static int finCount=2;
	public static int totalCount=2;
	public static int consumeCount=2;
	public static boolean finished=false;

	public static void main(String[] args) {
		//1 get cyphertext
		
		//2 create workers
		
		//3 threads decrypt
		
		//4 threads score the plaintext
		
		//5 thread puts result in queue
		
		//6 consumer takes result from queue and compare
		
		//7 output plaintext
		
		String cypherText="";
		
		//Get Cyphertext
		//cypherText= getCyphertext();
		cypherText="SATTMTSLSOETAEEPHHCGTTEA";	
	
		//STOPTHEMATTHECASTLEGATES
		//String cypherText = "SATTMTSLSOETAEEPHHCGTTEA";
		
		//fill quadgramMap
		QuadGramMap.fillMap();	
		
			
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
		
		
		
		
		//output plaintext, key and score of the highest scoring decrypted text
		 //System.out.println("output of plaintext, key and score of the highest scoring decrypted text");
		//while(consumeCount<totalCount){
		while(finished==false){
			//wait until all finished consuming
			//System.out.println(consumeCount+" "+finCount+" "+totalCount);
		}//end while
		
		c.getResults();

	}
	
	static void showMenu(){
		System.out.println("Option 1 - Enter cyphertext by keyboard:");	
		System.out.println("Option 2 - Enter cyphertext from file:");	
		System.out.println("Enter your option:");			
				
	}//end showMenu
	
	static String getCyphertext(){
		int option=0;
		String command;
		boolean valid=false;
		String text = "";
		do{
			showMenu();
			//option = console.nextInt();
			if (console.hasNextInt()){
				option = console.nextInt();   		    
			}
	        else {
	        	console.next();
	        	System.out.println("Invalid Input");
	        }
			//switch on option
			switch (option) {
			case 1:
				//enter cyphertext
				System.out.println("Enter your Cyphertext to be decrypted: Eg SATTMTSLSOETAEEPHHCGTTEA");
				text = console.next();
				text =text.toUpperCase();
			    valid=true;	
				break;
				
			case 2:
				//enter file directory
				System.out.println("Enter file directory of Cyphertext to be decrypted: Eg C:/myFolder/cyphertext.txt");
				//parseFile Method
				//
				valid=true;
				break;
			default:
				break;
			}
						
		}while(valid==false);
		
		return text;
	}//end getCyphertext

	public static synchronized void incrementTotalCount() {
        totalCount++;
    }
	public static synchronized void incrementFinCount() {
        finCount++;
    }
	public static synchronized void incrementConsumeCount() {
		consumeCount++;
    }
}//end runner
