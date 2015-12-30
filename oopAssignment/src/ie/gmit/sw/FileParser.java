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
		
		//InputStreamReader file= new InputStreamReader(new FileInputStream(fileName));
		
		//BufferedReader br = new BufferedReader(file);
		
		br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		
		String next;
		
		while((next = br.readLine())!= null){
			//add line to map
			//split the string
			String[] split = next.split(" ");
			
			//System.out.println(split[0]);
			//System.out.println(split[1]);
			
			double sNum = Double.parseDouble(split[1]);
			
			QuadGramMap.QMap.put(split[0], sNum);
			
		}//while
		
	}//parse

}
