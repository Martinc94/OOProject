package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class CypherParser {
	public CypherParser() {	
		//default Consturctor
	} 
	
	String parseFile(String fileName)throws IOException{
        String cypherText = "";
        String next = "";
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));		
		
		while((next = br.readLine())!= null){	
				cypherText+=next;
					
		}//while	
	
		br.close();
		
		//returns string of size 24 if string is larger than 24 this helps with large files creating lots of huge threads
		
		/*if(cypherText.length()>24){
			cypherText=cypherText.substring(0, 24);
			System.out.println(cypherText);
		}*/
		return cypherText;		
	}

}
