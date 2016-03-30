package com.example.user.calculatorv2;

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
	
	public Token(int type, double dval, OperatorInfo opInfo) {
		
		m_type = type;
		m_dval = dval;
		m_opInfo = opInfo;
		
	}
	
	public boolean isFunction() {
		
		if ((m_type == T_FUNCTION_SQRT)
			|| (m_type == T_FUNCTION_LN)
			|| (m_type == T_FUNCTION_SIN)) {
			
			return true; 
		}
		
		return false;
	}
	
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
	
	public boolean isUnary() {
		if ((m_type == T_OPERATOR_UNARY_PLUS)
				|| (m_type == T_OPERATOR_UNARY_MINUS)) {
			
			return true;
			
		}
		
		return false;
	}
	
	
	public int getType() {
		return m_type;
	}
	
	
	public double getValue() {
		return m_dval;
	}
	
	
	public OperatorInfo getOperatorInfo() {
		
		return m_opInfo;
		
	}
	
	// Return a string indicating the type of the token.
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
