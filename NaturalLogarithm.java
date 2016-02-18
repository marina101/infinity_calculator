/**
 * COMP 5541 - TOOLS AND TECHNIQUES FOR SOFTWARE ENGINEERING
 * 
 * @author Shuai Chen, zacchenshuai@gmail.com;
 *
 * Class NaturalLogarithm 
 * Implements the Natural Logarithm Algorithm by Using Taylor Series
 *
 * $Revision: 1.0 $
 * $Last Revision Date: 2016/02/17
 */

package edu.Concordia.Eternity.Algorithm;

import edu.Concordia.Eternity.Algorithm.main.power;

public class NaturalLogarithm{
	static double y = 0;
	static double m = 0;
	
	//Calculate the natural logarithm of x and the precision is 10^-n
	public static double calculate(double x) {
		
		
		//If x<=0, return false because x should be positive real number
		
		if(x<=0){
			System.out.println("False and x should be positive number!");
		}
		
		//If 0<x<2, use Taylor series to compute ln(x) directly
		
		else if(x>0 && x<2){
			double a=x-1;
			for(int i=1;i<=1000;i++){
				y=y+power.power(-1,i-1)*power.power(a,i)/i;
			}	
		}
		
		//If x>=2, use x/e to map x to interval (0,2) and then compute ln(x)
		
		else{
			while(x>=2){
				m=m+1;
				x=x/2.718281828459045;
			}
				double b=x-1;
				for(int j=1;j<=1000;j++){
					y=y+power.power(-1,j-1)*power.power(b,j)/j;
				}
				y=y+m;			
			}
		return y;
		}
}
