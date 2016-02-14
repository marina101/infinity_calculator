import java.util.EmptyStackException;


public class EvaluatorTest {
	
	public class InvalidExpressionException extends Exception {

		public InvalidExpressionException() {
			super("Expression is Invalid");
		}
		
		public InvalidExpressionException(String message) {
			super(message);
		}
		
	}
	

	public class MissingOperatorException extends Exception {

		public MissingOperatorException() {
			super("Expression is Invalid");
		}

		public MissingOperatorException(String message) {
			super(message);
		}

	}

	public static void main(String[] args) {
		Evaluator eval = new Evaluator();
		
		eval.setExpression("(9/3)*(3-20)*cos2-(e^3)");
		double evalResult = 0.0;
		try {
			try {
				evalResult = eval.calculate();
			} catch (Evaluator.InvalidExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Evaluator.MissingOperatorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyStackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double javaResult = (9/3)*(3-20)*Math.cos(2)-(Math.exp(3));
		final double PRES = 0.000000001;
		
		if (Math.abs(evalResult - javaResult) < PRES) {
			System.out.println("It just works!");
		} else {
			System.out.println("It just doesn't works!");
		}
	}

}
