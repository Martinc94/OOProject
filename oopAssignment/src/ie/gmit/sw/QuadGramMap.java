package ie.gmit.sw;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QuadGramMap {
	public static final int GRAM_SIZE =4;
	
	public static Map<String,Double> QMap = new ConcurrentHashMap<String,Double>();
	
	public static void fillMap() {
		//parse file
		FileParser fp = new FileParser();
		try {
			fp.parse();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}//end fillMap

}

