package edu.Concordia.Eternity.Algorithm;
/**
 * COMP 5541 - TOOLS AND TECHNIQUES FOR SOFTWARE ENGINEERING
 * 
 * @author TARNUM SHARMA, tarnumsharma@gmail.com;
 *
 * Class XpowertoY 
 * Implements the x power y by Using Taylor Series
 *
 * $Revision: 1.0 $
 * $Last Revision Date: 2016/02/17
 */
public class XpowertoY {
	
	 static double a = 1;
	 static double sum = 1;
	 static double i=1;
	 public static double xpowery(double x,double y){
		 
		 // when power<0, we return 1/xpowery(x,-y)
		 if(y<0){
			 return 1/xpowery(x,-y);
		 }
		 double j=NaturalLogarithm.calculate(x)*y;
		 
		 /* Using Taylor Series to implement x^y
		  * x^y = 1 + (lnx)y + (((lnx)^2)y^2)/2! + ..... + (((lnx)^n)y^n)/n!
		  * j=(lnx)y
		 */
		 while(a>1e-15){
			 a = a * j / i;
			 sum = sum + a;
			 i++;
		 }
		 
		 //Using optimization method to get approximate result  
		 double s = sum % 1;
	        if (s>0.999999999){
	        	sum = sum-s+1;
	        }
	        else if(s<0.000000001){
	            sum = sum - s;
	        }
		 return sum;
		 }
	 public static void main(String[] args){
			double a = XpowertoY.xpowery(5,2.5);
			System.out.println(a);
		}
}
	

