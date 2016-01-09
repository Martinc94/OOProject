package ie.gmit.sw;

public class Result implements Resultable {
	private String plaintext;
	private int key;
	private double score;
	
	public Result(String plaintext, int key, double score) {
		super();
		this.plaintext = plaintext;
		this.key = key;
		this.score = score;
	}

	public String getPlaintext() {
		return plaintext;
	}

	public void setPlaintext(String plaintext) {
		this.plaintext = plaintext;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}	

}
