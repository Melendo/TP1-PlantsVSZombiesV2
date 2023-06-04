package tp1.p2.exceptions;

public class NotCatchablePositionException extends InvalidPositionException{
	private static final long serialVersionUID = 1L;
    public NotCatchablePositionException(String text) {
           super(text);
       }

   public NotCatchablePositionException(String message, Throwable cause) {
       super(message, cause);
   }

   public NotCatchablePositionException(Throwable cause) {
       super(cause);
   }
}
