package com.example.user.calculatorv2;

/**
 * Scanner that proceed to the lexical analysis of a mathematical expression.
 * 
 * Mathematical expressions awaiting tokenization must be set using the setInput(String str) method.
 * The tokenization process is carried out by the nextToken() method.
 * Any call to this method will lead to the consumption and processing of the characters within the 
 * mathematical expression until either forming a token or encountering an error.
 * 
 * @author Jerome Charriere
 */
 
class CustomScanner {

	private String 	m_input;
	private boolean m_scanningComplete;
	private int		m_cursor;
	
	private static final int EOE = 0;
	
	
	
	/**
	 * Class constructor.
	 */
	public CustomScanner() {
		
	}
	
	
	
	/**
	 * Prepare the scanner for the tokenization of a mathematical expression.
	 * 
	 * @param String to scan.
	 */
	public void setInput(String str) {
		
		m_input = str;
		m_cursor = 0;
		m_scanningComplete = false;
		
	}
	
	
	
	/**
	 * Returns the next character in the expression and increase the cursor position by one.
	 * If the end of the expression has been reached, the method will return the value EOE.
	 * 
	 * @return Character at the current cursor position.
	 */
	private char nextChar() {
		
		// There is not need to continue if the scanner has completed scanning the entire expression.
		if (m_scanningComplete) {
			return EOE;
		}
		
		if (m_cursor >= (m_input.length())) {
			// The end of the expression has been reached.
			m_cursor++;
			return EOE;
		}
		
		// Return the next character and move cursor by one character.
		char c = m_input.charAt(m_cursor);
		m_cursor++;
		return c;
	}
	
	
	
	/**
	 * Helper method.
	 * Creates a token object.
	 * 
	 * @param type Type of the token.
	 * @param dval Value associated with the token. This value should be set to zero if the token is not supposed to have any value.
	 * @param opInfo OperatorInfo Instance describing the type of operator associated to the token. This argument should be left null if the type of the token is not an operator.
	 */
	private Token createToken(int type, double dval, OperatorInfo opInfo) {
		
		return new Token(type, dval, opInfo);
		
	}
	
	
	
	/** 
	 * Indicate if the scanner has finished scanning the entire mathematical expression.
	 * 
	 * @return True if the scanner has finished scanning the entire mathematical expression. False otherwise.
	 */
	public boolean isScanningComplete() {
		
		return m_scanningComplete;
	
	}
	
	
	
	/**
	 *  Rewind the reading cursor by one character
	 */
	private void backChar() {
		
		m_cursor--;
		
	}
	
	
	
	/**
	 * Process and consume characters of the mathematical expression until forming a new token.
	 * If the scanner has finished processing the mathematical expression, it will return a token instance of type T_EOE.
	 * 
	 * @return Token instance.
	 * @throws MathException if the scanner has encountered an invalid or badly formed lexical element.
	 */
	public Token nextToken() throws MathException {
		
		char c = nextChar();
		
		if (c == EOE) {
			m_scanningComplete = true;
			return createToken(Token.T_EOE, 0, null);
		}
		
		String stringBuffer = new String();
		
		if (CharacterClassifier.isLetter(c)) {
			
			stringBuffer += c;
			c = nextChar();
			
			// Check if we have 'e'.
			if (stringBuffer.equals("e") && (!CharacterClassifier.isLetter(c))) {
				backChar();
				return createToken(Token.T_CONSTANT_E, 0, null);
			}
			
			// Otherwise: keep buffering all the possible succeeding letters.
			while (CharacterClassifier.isLetter(c)) {
				stringBuffer += c;
				c = nextChar();
			}
			
			// We have encountered an element that is not a letter: we rewind by one character.
            		backChar();
			
			// Check if keyword is part of the set of defined mathematical functions.
			if (stringBuffer.equals("sqrt")) 	{ return createToken(Token.T_FUNCTION_SQRT, 0, null); }
			if (stringBuffer.equals("ln")) 		{ return createToken(Token.T_FUNCTION_LN, 0, null); }
			if (stringBuffer.equals("sin")) 	{ return createToken(Token.T_FUNCTION_SIN, 0, null); }
			
			// The character string does not correspond to any functions or constants: report the error.
			throw new MathException("Unknown function");
		}
		
		
		if (CharacterClassifier.isDigit(c)) {
			
			stringBuffer += c;
			c = nextChar();
			while (CharacterClassifier.isDigit(c)) {
				stringBuffer += c;
				c = nextChar();
			}
			
			// It may be a float.
			if (c == '.') {
				
				stringBuffer += c;
				c = nextChar();
				if (CharacterClassifier.isDigit(c)) {
					stringBuffer += c;
					c = nextChar();

					while (CharacterClassifier.isDigit(c)) {
						stringBuffer += c;
						c = nextChar();
					}
					backChar();
				}
				else {
					// Error.
					throw new MathException("Badly formed float");

				}
			}
			else {
				backChar();
			}
			
			// We have finished scanning a number.
			double value = Double.parseDouble(stringBuffer);
			return createToken(Token.T_NUMBER, value, null);
			
			
		}
		
		if (c == '(') { return createToken(Token.T_OPENPAR, 0, null); }
		if (c == ')') { return createToken(Token.T_CLOSEPAR, 0, null); }
		if (c == '+') { return createToken(Token.T_OPERATOR_PLUS, 0, new OperatorInfo(2, true)); }
		if (c == '-') { return createToken(Token.T_OPERATOR_MINUS, 0, new OperatorInfo(2, true)); }
		if (c == '*') { return createToken(Token.T_OPERATOR_MULT, 0, new OperatorInfo(3, true)); }
		if (c == '/') { return createToken(Token.T_OPERATOR_DIV, 0, new OperatorInfo(3, true)); }
		if (c == '^') { return createToken(Token.T_OPERATOR_POW, 0, new OperatorInfo(4, false)); }
		
		// Error: unknown token.
		throw new MathException("Unrecognised lexical element");
		
	}
		
}
	

