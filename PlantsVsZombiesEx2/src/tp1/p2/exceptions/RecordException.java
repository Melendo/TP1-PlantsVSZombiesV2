package tp1.p2.exceptions;

public class RecordException extends CommandParseException{
	private static final long serialVersionUID = 1L;
    public RecordException(String text) {
           super(text);
       }

   public RecordException(String message, Throwable cause) {
       super(message, cause);
   }

   public RecordException(Throwable cause) {
       super(cause);
   }
}
