package tp1.p2.exceptions;

public class GameException extends Exception {
	private static final long serialVersionUID = 1L;
	
	 public GameException(String text) {
	        super(text);
	    }

	public GameException(String message, Throwable cause) {
		super(message, cause);
	}

	public GameException(Throwable cause) {
		super(cause);
	}
}