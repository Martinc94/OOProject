package ie.gmit.sw;
/** Provides an interface that result classes must implement*/
public interface Resultable {
	/**Returns a String containing plaintext **/
	String getPlaintext();
	/**Sets the plaintext **/
	void setPlaintext(String plaintext);
	/** Gets key*/
	int getKey();
	/** Sets key*/
	void setKey(int key);
	/** Gets Score*/
	double getScore();
	/** Sets Score*/
	void setScore(double score);
}