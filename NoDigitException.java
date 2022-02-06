
public class NoDigitException extends Exception {
	public NoDigitException() {
		this("The password must contain at least one digit");
		
	}
	public NoDigitException(String massage) {
		super(massage);
	}

}
