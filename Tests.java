package com.example.user.calculatorv2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		
		Parser parser = new Parser();		
		
		// Correct capture of floating point numbers.
		double r1 = 0;
		try { r1 = parser.parse("3.54662+3.0-2.0000004"); } catch (MathException e) { e.printStackTrace(); }
		double exp1 = 3.54662+3.0-2.0000004;
		
		// Precedence test.
		double r2 = 0;
		try { r2 = parser.parse("2+3*4-2/4^3"); } catch (MathException e) { e.printStackTrace(); }
		double exp2 = 2+3*4-2/Math.pow(4, 3);
		
		// Power associativity test.
		double r3 = 0;
		try { r3 = parser.parse("2*2^6^2"); } catch (MathException e) { e.printStackTrace(); }
		double exp3 = 2*Math.pow(2, Math.pow(6, 2));
		
		// Unary test.
		double r4 = 0;
		try { r4 = parser.parse("-2+-+-+3---2*-2"); } catch (MathException e) { e.printStackTrace(); }
		double exp4 = -2+3-2*-2; // Java somehow doesn't allow multiple unary operators following each others.
		
		// Paranthesis test.
		double r5 = 0;
		try { r5 = parser.parse("50+(8-(2*(1+2))*4)*e^-(3+2)+-(4)"); } catch (MathException e) { e.printStackTrace(); }
		double exp5 = 50+(8-(2*(1+2))*4)*Math.pow(Math.E, -(3+2))+-4;
		
		// Func test 1.
		double r6 = 0;
		try { r6 = parser.parse("sin(3)+ln(60-(4*8))*sqrt(3/4/6)"); } catch (MathException e) { e.printStackTrace(); }
		double exp6 = Math.sin(3)+Math.log(60-(4*8))*Math.sqrt(3.0/4.0/6.0);
		
		// Func test 2.
		double r7 = 0;
		try { r7 = parser.parse("e^-10^2"); } catch (MathException e) { e.printStackTrace(); }
		double exp7 = Math.pow(Math.E, -Math.pow(10, 2));		
		
		
		double errMargin = 0.000000000001; // Small error margin.
	
		assertEquals(r1, exp1, 0);
		assertEquals(r2, exp2, 0);
		assertEquals(r3, exp3, 1);
		assertEquals(r4, exp4, 0);
		assertEquals(r5, exp5, 0);
		assertEquals(r6, exp6, errMargin);
		assertEquals(r7, exp7, errMargin);
		
				
	}

}
