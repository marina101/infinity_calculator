/**
 * COMP 5541 - TOOLS AND TECHNIQUES FOR SOFTWARE ENGINEERING
 * 
 * @author Ricardo B Oliveira, ricardobezerraoliveira@gmail.com;
 *
 * Class TestDriver 
 * Input Test
 *
 * $Revision: 1.0 $
 * $Last Revision Date: 2016/02/01
 */


package edu.Concordia.Eternity.Console;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import edu.Concordia.Eternity.Algorithm.*;

public class TestDriver {

	public static void main(String[] args) throws IOException {
		
		//Input ----------------------------------------------------------------------
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input the numbers or 'f' to calculate the result: ");
		
		List<Double> values = new LinkedList<Double>();

		String s = "0";
		while(!s.toUpperCase().equals("F"))
		{
			s = console.readLine();
			if(!s.toUpperCase().equals("F")){
				values.add(Double.parseDouble(s));
			}
		}

		// Output --------------------------------------------------------------------		
		StandardDeviation stdAlgorithm = new StandardDeviation();
		System.out.println(stdAlgorithm.Calculate(values));
		
	}

}
