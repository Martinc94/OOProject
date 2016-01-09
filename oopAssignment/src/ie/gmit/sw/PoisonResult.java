package ie.gmit.sw;

public class PoisonResult implements Resultable{

	public PoisonResult(String plaintext, int key, double score) {
		setPlaintext(plaintext); 
		setKey(key);
		setScore(score);	
	}

	@Override
	public String getPlaintext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlaintext(String plaintext) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getKey() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setKey(int key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setScore(double score) {
		// TODO Auto-generated method stub
		
	}
	
}
