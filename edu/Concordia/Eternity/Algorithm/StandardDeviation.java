/**
 * COMP 5541 - TOOLS AND TECHNIQUES FOR SOFTWARE ENGINEERING
 * 
 * @author Ricardo B Oliveira, ricardobezerraoliveira@gmail.com;
 *
 * Class StandardDeviation 
 * Implements the Standard Deviation Algorithm
 *
 * $Revision: 1.0 $
 * $Last Revision Date: 2016/02/01
 */

package edu.Concordia.Eternity.Algorithm;

import java.util.List;

import edu.Concordia.Eternity.Interface.*;

public class StandardDeviation implements IAlgorithm {

	@Override
	public double Calculate(List<Double> values) {
		 
		double valueSum = 0;
		double valueSumSquareDifference = 0;		
		double valueCount = 0;
		double valueAverage = 0;
		double standardDeviation = 0;
				
		// Calculates the avarage value
		
		for(double value : values)
		{
			valueSum += value;
			valueCount++;
		}	
		valueAverage = valueSum / valueCount;

		// Calculates the Standard Deviation
		
		for(double value : values)
		{
			double valueSquareDifference = Math.pow((value - valueAverage),2);
			valueSumSquareDifference += valueSquareDifference;
		}	
	
		standardDeviation = Math.pow((valueSumSquareDifference / valueCount) , 0.5);
		
		return standardDeviation;
		
	}

}
