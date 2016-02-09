/**
 * COMP 5541 - TOOLS AND TECHNIQUES FOR SOFTWARE ENGINEERING
 * 
 * @author Ricardo B Oliveira, ricardobezerraoliveira@gmail.com;
 *
 * Class AlgorithmExample 
 * Implements one simple class to exemplify the use of the IAlgorithm interface and JUnit Test Case.
 *
 * $Revision: 1.0 $
 * $Last Revision Date: 2016/02/01
 */

package edu.Concordia.Eternity.Algorithm;

import java.util.List;

import edu.Concordia.Eternity.Interface.*;

public class AlgorithmExample implements IAlgorithm {

	public double Calculate(List<Double> values) {

		double a = values.get(0);	
		double b = values.get(1);
		
		double c = a + b;
		
		return c;
		
	}

}
