package ie.gmit.sw;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;;

public class FileParser {
	
	public Map<String,Double>Parse(String file){
		Map<String,Double> temp = new ConcurrentHashMap<String,Double>();
		return temp;
	}
	
	@SuppressWarnings("resource")
	public void parse() throws IOException{
		String fileName="4grams.txt";
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		
		String next;
		
		while((next = br.readLine())!= null){	
			//split the string
			String[] split = next.split(" ");
			//parse the double
			double sNum = Double.parseDouble(split[1]);
			//add to map
			QuadGramMap.QMap.put(split[0], sNum);
			
		}//while	
	}//parse
}//end fileparser
