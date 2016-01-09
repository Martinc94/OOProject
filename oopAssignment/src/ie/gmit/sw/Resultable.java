package ie.gmit.sw;

public interface Resultable {

	String getPlaintext();

	void setPlaintext(String plaintext);

	int getKey();

	void setKey(int key);

	double getScore();

	void setScore(double score);
}