
public class InvalidExpressionException extends Exception {
	
	public InvalidExpressionException() {
		super("Expression is Invalid");
	}
	
	public InvalidExpressionException(String message) {
		super(message);
	}
	
}
