package ie.gmit.sw;
import java.io.IOException;
import java.util.Scanner;

public class Runner {
	//public static int count;
	static Scanner console = new Scanner(System.in);
	public static int finCount=2;
	public static int totalCount=2;
	public static int consumeCount=2;
	public static boolean finished=false;

	public static void main(String[] args) {
		String cypherText="";
		
		//Get Cyphertext
		cypherText= getCyphertext();
		System.out.println(cypherText);
		
		//reading from file doesnt add poison result

		//STOPTHEMATTHECASTLEGATES - used while testing code
		//cypherText = "SATTMTSLSOETAEEPHHCGTTEA";
		
		//fill quadgramMap
		QuadGramMap.fillMap();			
			
		//create a worker with threads that decrypts the cyphertext with different keys
		System.out.println("Starting To Decrypt");
		Worker w = new Worker(cypherText);
		
		//creates a new consumer with threads that check score and returns best result
		System.out.println("Starting To Consume");
		Consumer c = new Consumer();	
		
		while(getFinished()==false){
			//wait until all finished consuming
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
		//String command;
		boolean valid=false;
		String input = "";
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
				input = console.next();
				text =input.toUpperCase();
			    valid=true;	
				break;
				
			case 2:
				//enter file directory
				System.out.println("Enter file directory of Cyphertext to be decrypted: Eg C:/myFolder/cyphertext.txt");
				//C:/Users/Martinc/Desktop/file1.txt
				//input = console.next();
				input="C:/Users/Martinc/Desktop/file1.txt";
				CypherParser cy = new CypherParser();
				try {
					text=cy.parseFile(input);
				} catch (IOException e) {
					System.out.println("Unable to open File");
					e.printStackTrace();
				}
				valid=true;
				break;
			default:
				break;
			}
						
		}while(valid==false);
		
		return text;
	}//end getCyphertext

	//Methods to keep Syncronization of variables
	public static synchronized void incrementTotalCount() {
        totalCount++;
    }
	public static synchronized void incrementFinCount() {
        finCount++;
    }
	public static synchronized void incrementConsumeCount() {
		consumeCount++;
    }
	
	public static synchronized boolean getFinished(){
		return finished;	
	}
	
	public static synchronized int getTotalCount(){
		return totalCount;	
	}
	public static synchronized int getFinCount(){
		return finCount;	
	}
	public static synchronized int getConsumeCount(){
		return consumeCount;	
	}
	
	public static synchronized void setFinished(){
		finished=true;	
	}
}//end runner
