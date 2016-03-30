package com.example.user.calculatorv2;

public class OperatorInfo {

	private int 	m_precedenceLevel;
	private boolean m_leftAssociative;
	
	OperatorInfo(int precedenceLevel, boolean leftAssociative) {
		
		m_precedenceLevel = precedenceLevel;
		m_leftAssociative = leftAssociative;
		
	}
	
	public boolean isLeftAssociative() {
		
		if (m_leftAssociative) {
			return true;
		}
		
		return false;
		
	}
	
	public int getPrecedenceLevel() {
		
		return m_precedenceLevel;
		
	}
	
	
	
	
}
