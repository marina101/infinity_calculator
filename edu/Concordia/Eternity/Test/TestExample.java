/**
 * COMP 5541 - TOOLS AND TECHNIQUES FOR SOFTWARE ENGINEERING
 * 
 * @author Ricardo B Oliveira, ricardobezerraoliveira@gmail.com;
 *
 * Class TestExample 
 * Implements one JUnit Test Case example.
 *
 * $Revision: 1.0 $
 * $Last Revision Date: 2016/02/01
 */

package edu.Concordia.Eternity.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import edu.Concordia.Eternity.Algorithm.*;

public class TestExample {

	@Test
	public void test() {
		
		// Arrange -----------------------------------------
		
		AlgorithmExample example = new AlgorithmExample();
		
		Double var1 = (double) 6;
		Double var2 = (double) 2;
		Double expectedResult = (double) 8;
		
		List<Double> values = new LinkedList<Double>();
		values.add(var1);
		values.add(var2);

		// Act ---------------------------------------------	

		Double result = example.Calculate(values);
			
		// Assert ------------------------------------------
	
		assertTrue(0.0 == (expectedResult - result));

	}

}
