package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/** Parses a file given file directory as a String(FileName)*/
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
		
		return cypherText;		
	}

}
