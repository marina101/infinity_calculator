package com.example.user.calculatorv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Parser {
	
	public CustomScanner m_scanner;
	
	public Parser() {
		
		m_scanner = new CustomScanner();
		
	}
	
	
	public double parse(String expression) throws MathException {
		
		// Prepare the scanner.
		m_scanner.setInput(expression);
		
		Queue<Token> rpn = prepare(expression);
		
		double result = evaluate(rpn);

		return result;
	}
	
	
	
	private Queue<Token> prepare(String expression) throws MathException {
		
		Stack<Token> opStack = new Stack<Token>();
		Queue<Token> output = new LinkedList<Token>();
		
		// Store a reference of the last token processed.
		// This will help us determine if a minus/plus operator is either unary or binary.
		Token lastTk = null;
		
		Token tk = m_scanner.nextToken();
        while (true) {

            int tkType = tk.getType();

            // Handle the special case of the use of the E constant.
            if (lastTk != null) {
                if ((lastTk.getType() == Token.T_CONSTANT_E) && (tkType != Token.T_OPERATOR_POW)) {
                    throw new MathException("e must go with power function");
                }
            }


            if (tk.getType() == Token.T_EOE) {

                // End of the expression reached.
                break;
            }
						
			if (tkType == Token.T_NUMBER || tkType == Token.T_CONSTANT_E) {
				output.add(tk);
			}
					
			if (tk.isFunction()) {
				opStack.push(tk);
			}
			
			if (tk.isOperator()) {
				
				if (tkType == Token.T_OPERATOR_PLUS || tkType == Token.T_OPERATOR_MINUS) {
					
					// If the preceding token is an operator or if the operator is the first token encountered in the expression then the current plus/minus token must be set as a unary operator.
					if (lastTk == null || lastTk.isOperator() || (lastTk.getType() == Token.T_OPENPAR)) {
						int newType;
						if (tkType == Token.T_OPERATOR_PLUS) { newType = Token.T_OPERATOR_UNARY_PLUS; }
						else { newType = Token.T_OPERATOR_UNARY_MINUS; }
						
						// Replace current token with a unary operator
						tk = new Token(newType, 0, new OperatorInfo(4, false));
					}
					
				}
				
				while (!opStack.isEmpty()) {
										
					Token top = opStack.peek();
										
					if (top.getType() == Token.T_OPENPAR || top.isFunction()) {
						break;
					}
					
					int tkPrecedenceLvl = tk.getOperatorInfo().getPrecedenceLevel();
					int topPrecedenceLvl = top.getOperatorInfo().getPrecedenceLevel();
					boolean tkLeftAssoc = tk.getOperatorInfo().isLeftAssociative();
					
					if 	( (tkLeftAssoc && (tkPrecedenceLvl <= topPrecedenceLvl))
					 || (!tkLeftAssoc && (tkPrecedenceLvl < topPrecedenceLvl))) {
						output.add(opStack.pop());
					}
					else {
						break;
					}
				}
				opStack.push(tk);
			}
			
			if (tkType == Token.T_OPENPAR) {
					opStack.push(tk);
			}
			
			if (tkType == Token.T_CLOSEPAR) {
				while (!opStack.isEmpty() && (opStack.peek().getType() != Token.T_OPENPAR)) {
					output.add(opStack.pop());
				}
				
				if (opStack.isEmpty()) {
					// Error: Mismatched parentheses
					throw new MathException("Mismatched parantheses");
				}
				
				else {
					opStack.pop();
				}
				
				if (!opStack.isEmpty() && opStack.peek().isFunction()) {
					output.add(opStack.pop());
				}
			}
			
			lastTk = tk;
			tk = m_scanner.nextToken();
		}
		
		// No more tokens to read.
		while (!opStack.isEmpty()) {
			int topType = opStack.peek().getType();
			if ((topType == Token.T_OPENPAR) || (topType == Token.T_CLOSEPAR)) {
				// Error: Mismatched parentheses.
				throw new MathException("Mismatched parantheses");
			}
			
			output.add(opStack.pop());
		}
		
		return output;
		
		
	}
	
	
	private double evaluate(Queue<Token> inputQueue) throws MathException {
		
		Stack<Token> stack = new Stack<Token>();
		double result = 0;
		
		while (!inputQueue.isEmpty()) {
			
			
			Token tk = inputQueue.poll();
			int tkType = tk.getType();
									
			if (tkType == Token.T_NUMBER || tkType == Token.T_CONSTANT_E) {
				stack.push(tk);
			}
			
			if (tk.isFunction()) {
								
				if (stack.isEmpty()) {
					throw new MathException("Insufficient values");
				}
								
				double arg = stack.pop().getValue();
				
				if (tkType == Token.T_FUNCTION_SIN) 	{ result = Algorithms.sin(arg); }
				if (tkType == Token.T_FUNCTION_LN) 		{ result = Algorithms.natLog(arg); }
				if (tkType == Token.T_FUNCTION_SQRT) 	{ result = Algorithms.sqrt(arg); }
				
				stack.push(new Token(Token.T_NUMBER, result, null));
				
				
			}
			
			
			if (tk.isUnary()) {
								
				if (stack.isEmpty()) {
					throw new MathException("Insufficient values");
				}
				
				 Token right = stack.pop();
				if (tkType == Token.T_OPERATOR_UNARY_PLUS) {
					result = right.getValue() *  1;
				}
				else {
					result = right.getValue() * -1;
				}
				
				stack.push(new Token(Token.T_NUMBER, result, null));
				
			}
			
				
			else if (tk.isOperator()) {
								
				if (stack.size() < 2) {
					// Error: invalid math expression
					throw new MathException("Insufficient values inputed.");
                }

                Token right =  stack.pop();
				Token left = stack.pop();
				
				
				// Check for special cases.
                if (tkType == Token.T_OPERATOR_POW) {
					
					// e^x
					if (left.getType() == Token.T_CONSTANT_E) {
						result = Algorithms.exp(right.getValue());
					}
					
					// 10^x
					else if (left.getValue() == 10) {
						
						result = Algorithms.tenEx(right.getValue());
						
					}
					
					// x^y
					else {
						
						result = Algorithms.power(left.getValue(), right.getValue());
						
					}
					
				}
				
				double leftVal = left.getValue();
				double rightVal = right.getValue();
				
				if (tkType == Token.T_OPERATOR_DIV) 	{
					
					// Report error if division by zero
					if (rightVal == 0) { throw new MathException("Division by zero."); }
					
					result = leftVal / rightVal; 
				}
				
				if (tkType == Token.T_OPERATOR_MULT) 	{ result = leftVal * rightVal; }
				if (tkType == Token.T_OPERATOR_MINUS) 	{ result = leftVal - rightVal; }
				if (tkType == Token.T_OPERATOR_PLUS) 	{ result = leftVal + rightVal; }
												
				stack.push(new Token(Token.T_NUMBER, result, null));
				
				
			}
				
		}
		
		if (stack.size() > 1) {
			// Error: invalid math expression
			throw new MathException("Too many values");
			
		}
		else {
			// The stack should hold one last element representing the value of the calculated expression.
			return stack.pop().getValue();
		}
			
			
	}
		
			
	
	
	
}
