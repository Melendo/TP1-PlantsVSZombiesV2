package tp1.p2.exceptions;

public class InvalidPositionException extends CommandExecuteException{
	private static final long serialVersionUID = 1L;
    public InvalidPositionException(String text) {
           super(text);
       }

   public InvalidPositionException(String message, Throwable cause) {
       super(message, cause);
   }

   public InvalidPositionException(Throwable cause) {
       super(cause);
   }
}
