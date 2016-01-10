package ie.gmit.sw;
import java.io.IOException;
import java.util.Scanner;

public class Runner {
	static Scanner console = new Scanner(System.in);
	/**Int that keeps count when a thread finishes*/
	public static int finCount=2;
	/**Int that keeps count of total amount of thread*/
	public static int totalCount=2;
	
	/**Main method that starts program.
	 *  It gets the Cyphertext from user, Starts Decrypter Threads, Starts Consumer and Prints Results. */
	public static void main(String[] args) {	
		//Get Cyphertext
		String cypherText= getCyphertext();
		//STOPTHEMATTHECASTLEGATES - used while testing code
		//cypherText = "SATTMTSLSOETAEEPHHCGTTEA";
		
		//fill quadgramMap
		QuadGramMap.fillMap();			
		
		//create a worker with threads that decrypts the cyphertext with different keys
		Worker w = new Worker(cypherText);
		
		//creates a new consumer with threads that check score and returns best result
		Consumer c = new Consumer();	
		
		c.getResults();		
	}
	/**Displays a menu on the Command line.*/
	static void showMenu(){
		System.out.println("Option 1 - Enter cyphertext by keyboard:");	
		System.out.println("Option 2 - Enter cyphertext from file:");	
		System.out.println("Enter your option:");			
				
	}//end showMenu
	
	/**Returns a string Containing Cyphertext from the Command line or from a file.*/
	static String getCyphertext(){
		int option=0;
		boolean valid=false;
		String input = "";
		String text = "";
		do{
			showMenu();
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
				input = console.next();
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
	/**Method to keep Syncronization of incrementing totalCount.*/
	public static synchronized void incrementTotalCount() {
        totalCount++;
    }
	/**Method to keep Syncronization of incrementing finCount.*/
	public static synchronized void incrementFinCount() {
        finCount++;
    }	
	/**Method to keep Syncronization while returning totalCount.*/
	public static synchronized int getTotalCount(){
		return totalCount;	
	}
	/**Method to keep Syncronization while returning finCount.*/
	public static synchronized int getFinCount(){
		 return finCount;	
	}		
	
}//end runner
