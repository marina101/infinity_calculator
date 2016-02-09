/**
 * COMP 5541 - TOOLS AND TECHNIQUES FOR SOFTWARE ENGINEERING
 * 
 * @author Ricardo B Oliveira, ricardobezerraoliveira@gmail.com;
 *
 * Class IAlgorithm 
 * Provides a simple interface to be shared among the algorithms.
 *
 * $Revision: 1.0 $
 * $Last Revision Date: 2016/02/01
 */

package edu.Concordia.Eternity.Interface;

import java.util.List;

public interface IAlgorithm {

	public double Calculate(List<Double> values);
	
}
