
public class UnmatchedException extends Exception {
	
	/*
	 * constructor
	 */
	public UnmatchedException() {
		this("The passwords do not match");
	}
	public UnmatchedException(String massage) {
		super(massage);
	}

}
