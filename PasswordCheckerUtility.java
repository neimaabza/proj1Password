import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


   public class PasswordCheckerUtility{
	   // field
	   private static String password;
	   private static String passwordConfirm;
	   
	   //  defult constructor
	   public PasswordCheckerUtility(String password, String passwordConfirm) {
		   this.password = password;
		   this.passwordConfirm = passwordConfirm;
		   
	   }
	   
	   //  Compare equality of two passwords
	   // throws UnmatchedException
	   public static void comparePasswords(String password,String passwordConfirm) throws UnmatchedException {
		   if(!comparePasswordsWithReturn(password,passwordConfirm)) {
			   throw new UnmatchedException();
			   
		   }
		   
		   
	   }
	   //Compare equality of two passwords
	   // return true if both same (case sensitive)
	   public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		   if(!password.equals(passwordConfirm)) {
			   return false;	   
		   }
		   return true;
		   
	   }
	   //Reads a file of passwords and the passwords that failed the check will be added to an invalidPasswords with the reason
       // @Return invalidPasswords
	   
	   public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		   ArrayList<String>invalidPasswords  = new ArrayList<String>();
		   try {
			   for(String password : passwords) {
				   if (!isValidPassword(password)) {
					   invalidPasswords.add(password);
				   }
			   }
			   return invalidPasswords;
		   } catch(Exception ex) {
			   return invalidPasswords;
		   }
		   
		   
	   }
	   //Weak password length check - Password contains 6 to 9 characters , still considers valid, just weak
      //@Throw  new WeakPasswordException
	   //@Return true if passwird contains 6 to 9 character
	   public static boolean hasBetweenSixAndNineChars(String password) throws WeakPasswordException  {
		    int minLength = 6;
		    int maxLength = 9;
		    if (password.length() >= minLength && password.length() <= maxLength) {
		    	return true;
		    }
		   
		    throw new WeakPasswordException();
	   }
	   //Checks the password Digit requirement - Password must contain a numeric character
	   // @throws NoDigitException
	   //@Return true if meet Digit requirement
	   public static boolean hasDigit(String password)throws NoDigitException{
		  for (int i = 0; i < password.length(); i++) {
			  if (Character.isDigit(password.charAt(i))) {
				  return true;
			  }
		  }
		  throw new NoDigitException(); 
	   }
	   //Checks the password lowercase requirement - Password must contain a lowercase alpha character
       // @Throws NoLowerAlphaException
	   // @Return true if meet lowercase requirement
	   public static boolean hasLowerAlpha(String password)throws NoLowerAlphaException{
		   for (int i = 0; i < password.length(); i++) {
				  if (Character.isLowerCase(password.charAt(i))) {
					  return true;
				  }
			  }
		   throw new NoLowerAlphaException();   
	   }
	   //Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
       //@Return false if does NOT meet Sequence requirement
	   // @Throws InvalidSequenceException
	   public static boolean hasSameCharInSequence(String password)throws InvalidSequenceException{
		   int count = 0;
		   for(int i =0; i < password.length()-1; i++) {
			   if(password.charAt(i)== password.charAt(i+1)) {
				   count++;
			   }
		   }
		   if(count >= 2) {
			   throw new InvalidSequenceException();
		   }
		   return true;
	   }
	   //Checks the password SpecialCharacter requirement - Password must contain a Special Character
	   // @Return true if meet SpecialCharacter requirement
	   //@Throws NoSpecialCharacterException
	   public static boolean hasSpecialChar(String password)throws NoSpecialCharacterException{
		
		   for(int i = 0; i < password.length(); i++) {
			   char a= password.charAt(i);
				   if(!Character.isDigit(a)&& !Character.isLetter(a)&& !Character.isWhitespace(a)) {
					   return true;
					   
				   }
				   
		   }
		  throw new NoSpecialCharacterException();
		   
	   }
	   //Checks the password alpha character requirement - Password must contain an uppercase alpha character
       // return true if meet alpha character requirement
	   // Throws NoUpperAlphaExceptio
	   public static boolean hasUpperAlpha(String password)throws NoUpperAlphaException{
		   for (int i = 0; i < password.length(); i++) {
				  if (Character.isUpperCase(password.charAt(i))) {
					  return true;
				  }
			  }
		   throw new  NoUpperAlphaException();   
		   
		   
	   }
	   //Checks the password length requirement - – The password must be at least 6 characters long
       //Return true if meet min length requirement
	   // Throws LengthException
	   public static boolean isValidLength(String password)throws LengthException{
		    if(password.length()>= 6) {
		    	return true;
		    }
		   throw new LengthException();
	   }
	   /**
	    * Throws:LengthException - thrown if length is less than 6 characters
	   @throws - NoUpperAlphaException if no uppercase alphabetic
	   @throws - NoLowerAlphaException if no lowercase alphabetic
	   @throws - NoDigitException if no digit
	   @throws - NoSpecialCharacterException if does not meet SpecialCharacter requirement
	   @throws - InvalidSequenceException if more than 2 of same character.
	    */
	   
	   public static boolean isValidPassword(String password)throws LengthException,NoUpperAlphaException,NoLowerAlphaException,NoDigitException,
           NoSpecialCharacterException, InvalidSequenceException{
		   
		   if(
				   isValidLength(password) &&
				   hasUpperAlpha(password) &&
				   hasLowerAlpha(password) &&
				   hasSpecialChar(password) &&
				   hasDigit(password) &&
				   hasSameCharInSequence(password)
	         ) {
			   return true;
		   }
		   return false;
	   }
	   //Checks if password is valid but between 6 -9 characters
	   //@throws WeakPasswordException
	   //@return  if length of password is between 6 and 9 (inclusive).
	   
	   public static boolean isWeakPassword(String password)throws WeakPasswordException{
		   
		   return (password.length()>= 6 &&password.length() < 9);
		   
	   }
	   
	   
   }
  
   

	
	


