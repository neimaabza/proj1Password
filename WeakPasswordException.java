

public class WeakPasswordException extends Exception {
	public WeakPasswordException() {
		this("The password is OK but weak - it contains fewer than 10 characters");
		
	}
	public WeakPasswordException(String massage) {
		super(massage);
	}

}

