package edu.Concordia.Eternity.Algorithm;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import org.junit.Test;


public class AlgorithmTest_NaturalLogarithm {
	
	@Test
	public void test() {
		
		// Arrange -----------------------------------------
		

		Double var1 = (double) 3.141592653589793;
		Double expectedResult1 = (double)1.44729886 ;
		
		Double var2 = (double) 30;
		Double expectedResult2 = (double)3.401197382 ;
	

		// Act ---------------------------------------------	

		Double result1 = NaturalLogarithm.calculate(var1);
		Double result2 = NaturalLogarithm.calculate(var2);
			
		// Assert ------------------------------------------
	
		assertTrue(0.0 == ((Double)(expectedResult1 - result1)).intValue());
		assertTrue(0.0 == ((Double)(expectedResult2 - result2)).intValue());

	}


}

