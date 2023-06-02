package tp1.p2.exceptions;

public class NotEnoughCoinsException extends CommandExecuteException{
	private static final long serialVersionUID = 1L;
    public NotEnoughCoinsException(String text) {
           super(text);
       }

   public NotEnoughCoinsException(String message, Throwable cause) {
       super(message, cause);
   }

   public NotEnoughCoinsException(Throwable cause) {
       super(cause);
   }
}

