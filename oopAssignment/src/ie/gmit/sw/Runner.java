package ie.gmit.sw;

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
		
		Worker cy = new Worker(cypherText);
		
		for(int i = 2;i<=cypherText.length()/2;i++ ){
			System.out.println("creating worker thread with key "+i);
			new Thread(new Decrypter(Consumer.queue, cypherText,i)).start();
			
		}
		
		
		
		for (int j = 0; j < 1000000; j++) {
			
		}
		
		
		 System.out.println("end");

	}

}
