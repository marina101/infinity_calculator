package edu.Concordia.Eternity.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import edu.Concordia.Eternity.Algorithm.*;

public class AlgorithmTest_Sin {

	@Test
	public void test() {
		
		// Arrange -----------------------------------------

		Sin sinAlgorithm = new Sin();
		List<Double> values = new LinkedList<Double>();
		double var;
		
		var = 30.0;
		Double expectedResult1 = -0.98803162;
		values.add(var);
		double result1 = sinAlgorithm.Calculate(values);
		
		var = 0.0;
		double expectedResult2 = 0.0;
		values.set(0, var);
		double result2 = sinAlgorithm.Calculate(values);
					
		// Assert ------------------------------------------
	
		assertTrue(0.0 == ((Double)(expectedResult1 - result1)).intValue());
		assertTrue(0.0 == ((Double)(expectedResult2 - result2)).intValue());

	}
	
	
}