package tp1.p2.exceptions;

public class NumberFormatException extends CommandParseException{
	private static final long serialVersionUID = 1L;
    public NumberFormatException(String text) {
           super(text);
       }

   public NumberFormatException(String message, Throwable cause) {
       super(message, cause);
   }

   public NumberFormatException(Throwable cause) {
       super(cause);
   }
}

