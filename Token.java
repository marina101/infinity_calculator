package com.example.user.calculatorv2;

/**
 * Bears informations related to a lexical element encountered in a mathematical expression.
 * 
 * @author Jerome Charriere
 */
 
public class Token {

	public static final int T_NUMBER 				= 0;
	public static final int T_FUNCTION_SQRT 		= 1;
	public static final int T_FUNCTION_LN 			= 2;
	public static final int T_FUNCTION_SIN 			= 3;
	public static final int T_OPENPAR 				= 4;
	public static final int T_CLOSEPAR 				= 5;
	public static final int T_OPERATOR_PLUS 		= 6;
	public static final int T_OPERATOR_MINUS 		= 7;
	public static final int T_OPERATOR_MULT 		= 8;
	public static final int T_OPERATOR_DIV 			= 9;
	public static final int T_OPERATOR_POW 			= 10;
	public static final int T_CONSTANT_E			= 11;
	public static final int T_EOE					= 12;
	public static final int T_OPERATOR_UNARY_PLUS 	= 13;
	public static final int T_OPERATOR_UNARY_MINUS 	= 14;
		
	private int 			m_type;
	private double 			m_dval;
	private OperatorInfo 	m_opInfo;
	
	
	
	/**
	 * Class constructor.
	 * 
	 * @param type Type of the token. 
	 * @param dval Value associated with the token. This value should be set to zero if the token is not supposed to have any value.
	 * @param opInfo Instance describing the type of operator associated to the token. This argument should be left null if the type of the token is not an operator.
	 */
	public Token(int type, double dval, OperatorInfo opInfo) {
		
		m_type = type;
		m_dval = dval;
		m_opInfo = opInfo;
		
	}
	
	
	
	/**
	 * Checks if the token is a function.
	 * 
	 * @return True if the token is a function. False otherwise.
	 */
	public boolean isFunction() {
		
		if ((m_type == T_FUNCTION_SQRT)
			|| (m_type == T_FUNCTION_LN)
			|| (m_type == T_FUNCTION_SIN)) {
			
			return true; 
		}
		
		return false;
	}
	
	
	
	/**
	 * Checks if the token is an operator.
	 * 
	 * @return True if the token is an operator. False otherwise.
	 */	
	public boolean isOperator() {
		
		if ((m_type == T_OPERATOR_PLUS)
				|| (m_type == T_OPERATOR_MINUS)
				|| (m_type == T_OPERATOR_MULT)
				|| (m_type == T_OPERATOR_DIV)
				|| (m_type == T_OPERATOR_UNARY_PLUS)
				|| (m_type == T_OPERATOR_UNARY_MINUS)
				|| (m_type == T_OPERATOR_POW)) {
				
				return true; 
			}
		
		return false;	
	}
	
	
	
	/**
	 * Checks if the token is a unary operator.
	 * 
	 * @return True if the token is a unary operator. False otherwise.
	 */
	public boolean isUnary() {
		if ((m_type == T_OPERATOR_UNARY_PLUS)
				|| (m_type == T_OPERATOR_UNARY_MINUS)) {
			
			return true;
			
		}
		
		return false;
	}
	
	
	
	/**
	 * Returns the type of the token.
	 * 
	 * @return The type of the token.
	 */	
	public int getType() {
		return m_type;
	}
	
	
	
	/**
	 * Returns the value associated with the token.
	 * 
	 * @return The value associated with the token.
	 */
	public double getValue() {
		return m_dval;
	}
	
	
	
	/**
	 * Returns the possible OperatorInfo instance associated with the token.
	 * 
	 * @return The possible OperatorInfo instance associated with the token.
	 */
	public OperatorInfo getOperatorInfo() {
		
		return m_opInfo;
		
	}
	
	
	
	/**
	 * Returns a string giving some informations about the token.
	 * Useful for debugging purposes.
	 * 
	 * @return Returns a string indicating the type of the token and the possible value associated with it.
	 */
	public String toString() {
		
		String typeStr = "";
		
		switch (m_type) {
			case T_NUMBER: 					typeStr = "T_NUMBER"; break;
			case T_FUNCTION_SQRT:			typeStr = "T_FUNCTION_SQRT"; break;
			case T_FUNCTION_LN:				typeStr = "T_FUNCTION_LN"; break;
			case T_FUNCTION_SIN:			typeStr = "T_FUNCTION_SIN"; break;	
			case T_OPENPAR:					typeStr = "T_OPENPAR"; break;
			case T_CLOSEPAR:				typeStr = "T_CLOSEPAR"; break;
			case T_OPERATOR_PLUS:			typeStr = "T_OPERATOR_PLUS"; break;
			case T_OPERATOR_MINUS:			typeStr = "T_OPERATOR_MINUS"; break;
			case T_OPERATOR_MULT:			typeStr = "T_OPERATOR_MULT"; break;
			case T_OPERATOR_DIV:			typeStr = "T_OPERATOR_DIV"; break;
			case T_OPERATOR_POW:			typeStr = "T_OPERATOR_POW"; break;
			case T_CONSTANT_E:				typeStr = "T_CONSTANT_E"; break;
			case T_EOE:						typeStr = "T_EOE"; break;
			case T_OPERATOR_UNARY_PLUS:		typeStr = "T_OPERATOR_UNARY_PLUS"; break;
			case T_OPERATOR_UNARY_MINUS:	typeStr = "T_OPERATOR_UNARY_MINUS"; break;
			
			// We should not go through here.
			default: break;
			
		}
		
		return "< " + typeStr + " ; val: " + Double.toString(m_dval) + " >";
		
	}
	
}
