import java.util.Deque;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

/**************************************************************************************************
 * Floating Point Evaluator for Java Console Calculator: Takes an mathematical expression and
 * returns the resulting expression.
 * 
 * Note that this evaluator has restrictions on what it can evaluate:
 *
 * 
 * Christopher Birkbeck
 * Montreal, Quebec, Canada
 * 
 * 02/13/2016
 *************************************************************************************************/


public class Evaluator {

	/* Math constant */

	public class MissingOperatorException extends Exception {
		
		public MissingOperatorException() {
			super("Expression is Invalid");
		}
		
		public MissingOperatorException(String message) {
			super(message);
		}
	}

	public class InvalidExpressionException extends Exception {
		
		public InvalidExpressionException() {
			super("Expression is Invalid");
		}
		
		public InvalidExpressionException(String message) {
			super(message);
		}
	}

	private final String E = "2.718281828459045";
	private final String PI = "3.141592653589793";
	
	/* Variables */
	
	String expression;
	double result;
	
	/* Constructors */
	
	public Evaluator() {
		expression = "";
		result = 0.0;
	}
	
	/* Public methods */
	
	public void setExpression(String exp) {
		expression = exp;
	}
	
	public String getExpression() {
		return new String(expression);
	}
	
	public double getResult() {
		return result;
	}
	
	public double calculate() throws NumberFormatException, EmptyStackException, InvalidExpressionException, MissingOperatorException {
		result = evaluate(tokenize(expression));
		
		return result;
	}
	
	/* Private Expression */
	
	/**
	 * Divides the program up into tokens into a queue of Strings to be examined with the evaluator method.
	 * 
	 * Note the tokenize method does not allow for whitespace, relies on having the no whitespace, nor any error in how the unary functions are spelled,
	 * It assumed that numbers will be formatted correctly (i.e. decimals will have only 0 or 1 decimal in them).
	 * It is assumed that the input methods would disallow invalid strings from being passed.
	 * 
	 * @param exp
	 * @return
	 * @throws InvalidExpressionException
	 */
	private Queue<String> tokenize(String exp) throws InvalidExpressionException {
		Queue<String> expressionQueue = new LinkedList<String>();	// Holds separated tokens.
		Queue<String> digitQueue = new LinkedList<String>(); 		// This queue is for the digits of a single number.
		
		boolean isANumber = false;									/* isANumber indicates when a number begins (i.e. when the method finds either a number
																	or a non-operator negative sign) and when it ends (when it finds whitespace or an operator). */
		boolean isOperatorNext = false;								/* isOperator indicates when the case of minus sign, if it either a negative sign for a number
																	or the negation operator.*/
		boolean isUniaryOpNext = true;								/* isUniaryOpNext indicates when a uniary operator is next.*/
		
		for (int i = 0; i < exp.length(); i++) {
			switch (exp.charAt(i)) {
			case '1':
				if (i < expression.length() - 2) {
					if (exp.charAt(i + 1) == '0' && exp.charAt(i + 2) == '^') {
						// Checks if the expression is 10^, and if so, will place a String "ten^" into the queue.
						expressionQueue.add("ten^");
						i += 2;
						isOperatorNext = false;
						isUniaryOpNext = true;
						break;
					}
				}
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			case '0':
			case '.':
				if (!isANumber) {
					// Switches 
					isANumber = true;
					isUniaryOpNext = false;
					isOperatorNext = true;
				}
				digitQueue.add(expression.substring(i, i + 1));
				break;
			case '+':
			case '*':
			case '/':
			case '^':
				if (isANumber) {
					expressionQueue.add(Evaluator.concatenate(digitQueue));
					isANumber = false;
				}
				expressionQueue.add(expression.substring(i, i + 1));
				isOperatorNext = false;
				isUniaryOpNext = true;
				break;
			case '-':
				if (isANumber) {
					expressionQueue.add(Evaluator.concatenate(digitQueue));
					isANumber = false;
					isUniaryOpNext = true;
					isOperatorNext = true;
				}
				if (isOperatorNext) {
					// If the next token is an operator, adds '-' to queue to be interpreted as operator.
					expressionQueue.add(expression.substring(i, i + 1));
					isUniaryOpNext = true;
					isOperatorNext = false;
				} else {
					// If the next token is an a number, begins the
					digitQueue.add(expression.substring(i, i + 1));
					isANumber = true;
					break;
				}
				break;
			case '(':
			case ')':
				if (isANumber) {
					expressionQueue.add(Evaluator.concatenate(digitQueue));
					isANumber = false;
				}
				expressionQueue.add(expression.substring(i, i + 1));
				break;
			case 'e':
				if (expression.charAt(i + 1) == '^') {
					// Checks if the expression is "e^", and if so, place the String "exp^" to the queue
					expressionQueue.add("exp^");
					i++;
					isOperatorNext = false;
				}
				break;
			case 'c':
				if (!isUniaryOpNext)
					throw new InvalidExpressionException();
				if (expression.charAt(i + 1) == 'o' && expression.charAt(i + 2) == 's') {
					expressionQueue.add("cos");
					i += 2;
				}
				break;
			case 's':
				if (!isUniaryOpNext)
					throw new InvalidExpressionException();
				if (expression.charAt(i + 1) == 'i' && expression.charAt(i + 2) == 'n') {
					expressionQueue.add("sin");
					i += 2;
				}
				break;
			case 't':
				if (!isUniaryOpNext)
					throw new InvalidExpressionException();
				if (expression.charAt(i + 1) == 'a' && expression.charAt(i + 2) == 'n') {
					expressionQueue.add("tan");
					i += 2;
				}
				break;
			case 'l':
				if (!isUniaryOpNext)
					throw new InvalidExpressionException();
				if (i < expression.length() - 1) {
					if (expression.charAt(i + 1) == 'n') {
						expressionQueue.add("ln");
						isOperatorNext = false;
						i++;
						break;
					} 
				}
				if (i < expression.length() - 2) {
					if (expression.charAt(i + 1) == 'o' && expression.charAt(i + 2) == 'g') {
						expressionQueue.add("log");
						isOperatorNext = false;
						i += 2;
						break;
					}
				}
			default:
				throw new InvalidExpressionException();
			}	
		}
		
		if (digitQueue.size() > 0) {
			/*Clears out the digit queue, if the expression ends with a bracket-less expression.*/
			expressionQueue.add(Evaluator.concatenate(digitQueue));
		}

		return expressionQueue;
	}
	
	/**
	 * Will concatenate elements from a queue of Sting until the queue is empty. 
	 * 
	 * @param queue Must be a queue of Strings.
	 * @return String
	 */
	private static String concatenate(Queue<String> queue) {
		String number = queue.remove();
		while (queue.size() > 0) 
			number = number + queue.remove();
		return number;
	}
	
	/**
	 * Takes a queue of String, each representing a token of operators, brackets and integers and produces a double, if valid.
	 * 
	 * @param expressionQueue A queue of Strings consisting of tokens of the expression.
	 * @return The result of the expression.
	 * @throws InvalidExpressionException If somehow there is still more results to be calculated.
	 * @throws EmptyStackException If there is a mismatch of brackets or operators without the proper operands.
	 * @throws NumberFormatException If an operand exceeds the allowed range of the java double (i.e. 1.40129846432481707E-45 to 3.40282346638528860E+38).
	 */
	private double evaluate(Queue<String> expressionQueue) throws InvalidExpressionException, EmptyStackException, NumberFormatException, MissingOperatorException {
		Deque<String> operators = new LinkedList<String>();	// Stores operators and brackets.
		Deque<Double> numbers = new LinkedList<Double>();	// Stores numbers.
		
		// Will empty the token stack.
		
		while (expressionQueue.size() != 0) {
			String next = expressionQueue.remove();
			
			// Looks if the token is a number, a left or right bracket or an operator.
			
			if ((next.startsWith("-") && next.length() > 1) || next.startsWith("1") || next.startsWith("2") || next.startsWith("3") ||next.startsWith("4") ||
				next.startsWith("5") || next.startsWith("6") || next.startsWith("7") || next.startsWith("8") || next.startsWith("9") || next.startsWith("0")) {
				// Looks for number tokens.
				numbers.push(Double.parseDouble(next));
			} else if (next.equals("(")) {
				operators.push(next);
			} else if (next.equals(")")) {
				while (operators.size() != 0 && !operators.peek().equals("(")) {
					// Will evaluate expression until either the operators stack has been exhausted or it find the left bracket.
					numbers.push(applyOperation(operators.pop(), numbers));
				}
				operators.pop();
			} else {
				while (operators.size() != 0 && (Evaluator.precedence(next) <= Evaluator.precedence(operators.peek()))) {
					// Will evaluate expression until either the operators stack has been exhausted or it find another operator of equal or great precedence.
					numbers.push(applyOperation(operators.pop(), numbers));
				}
				operators.push(next);
			} 

		}
		
		// Empties the operator queue.
		
		while (operators.size() != 0) {
			numbers.push(applyOperation(operators.pop(), numbers));
		}
		
		// If the number queue does not have 1 and only 1 in it, then the resulting expression is incorrect.
		
		if (numbers.size() != 1)
			throw new MissingOperatorException();
		
		return numbers.pop();
	}
	
	/**
	 * Takes the current operator and a stack of numbers and returns the resulting number.
	 * 
	 * @param currentOperator String representing the current operator.
	 * @param theNumbers A stack of numbers, implemented as Double.
	 * @return Double The result of the operation.
	 * @throws NumberFormatException
	 * @throws IllegalArgumentException
	 * @throws InvalidExpressionException
	 */
	private Double applyOperation(String currentOperator, Deque<Double> theNumbers) throws NumberFormatException, IllegalArgumentException, InvalidExpressionException {
		
		if (Evaluator.isBinary(currentOperator)) {
			Double number2 = theNumbers.pop();
			Double number1 = theNumbers.pop();
			
			if (currentOperator.equals("+")) {
				return number1 + number2;
			} else if (currentOperator.equals("-")) {
				return number1 - number2;
			} else if (currentOperator.equals("*")) {
				return number1 * number2;
			} else if (currentOperator.equals("^")) {
				return Math.pow(number1, number2);
			} else if (currentOperator.equals("/")) {
				if (number2 == 0)
					throw new IllegalArgumentException();
				
			}
			
			return number1 / number2;
		}
			
		if (currentOperator.equals("sqrt")) {
			if (theNumbers.peek() < 0)
				throw new NumberFormatException();
			else
				return Math.sqrt(theNumbers.pop());
		} else if (currentOperator.equals("sin")) {
			return Math.sin(theNumbers.pop());
		} else if (currentOperator.equals("cos")) {
			return Math.cos(theNumbers.pop());
		} else if (currentOperator.equals("tan")) {
			if (theNumbers.peek() % (Math.PI / 2) == 0)
				throw new NumberFormatException();
			return Math.tan(theNumbers.pop());
		} else if (currentOperator.equals("log")) {
			return Math.log10(theNumbers.pop());
		} else if (currentOperator.equals("ten^")) {
			return Math.pow(10, theNumbers.pop());
		} else if (currentOperator.equals("exp^")) {
			return Math.exp(theNumbers.pop());
		}

		return Math.log(theNumbers.pop());
	}

	/**
	 * Sees if the operator is either binary or unary.
	 * 
	 * @param operator
	 * @return
	 */
	private static boolean isBinary(String operator) {
		if (operator.equals("sqrt") || operator.equals("sin") || operator.equals("cos") || operator.equals("tan") ||
			operator.equals("log") || operator.equals("ln") || operator.equals("ten^") || operator.equals("exp^"))
			return false;
		
		return true;
	}
	
	/**
	 * Calculates the precedence of operators, with higher number meaning great precedence.
	 * 
	 * @param operand
	 * @return
	 */
	private static int precedence(String operator) {
		if (operator.equals("("))
			return 0;
		else if (operator.equals("+") || operator.equals("-"))
			return 1;
		else if (operator.equals("*") || operator.equals("/") || operator.equals("%"))
			return 2;
		else if (operator.equals("sqrt") || operator.equals("sin") || operator.equals("cos") || 
				 operator.equals("tan") || operator.equals("log") || operator.equals("ln"))
			return 3;
		
		// Exponential operators get precedence of 4.
		return 4;
	}
}
