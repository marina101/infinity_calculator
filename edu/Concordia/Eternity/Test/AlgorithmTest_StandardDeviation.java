/**
 * COMP 5541 - TOOLS AND TECHNIQUES FOR SOFTWARE ENGINEERING
 * 
 * @author Ricardo B Oliveira, ricardobezerraoliveira@gmail.com;
 *
 * Class TestExample 
 * Implements the Unit Test for the Standard Deviation Algorithm.
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

public class AlgorithmTest_StandardDeviation {

	@Test
	public void test() {
		
		// Arrange -----------------------------------------

		StandardDeviation stdAlgorithm = new StandardDeviation();
		
		double var1 = (double) 10;
		double var2 = (double) 20;
		double var3 = (double) 34;
		double var4 = (double) 56;
		double var5 = (double) 76;
		double var6 = (double) 54;
		Double expectedResult = (double) 22.61;
		
		List<Double> values = new LinkedList<Double>();
		values.add(var1);
		values.add(var2);
		values.add(var3);
		values.add(var4);
		values.add(var5);
		values.add(var6);
	
		// Act ---------------------------------------------	

		Double result = stdAlgorithm.Calculate(values);
			
		// Assert ------------------------------------------
	
		assertTrue(0.0 == ((Double)(expectedResult - result)).intValue());

	}

}
