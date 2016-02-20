import java.util.List;


public class Algorithms {
	
	private static final double LN10 = 	2.3025850929940457;
	private static final double PI = 	3.14159265359;
	
	
	private static LookUpTable 	KTable;
	private static LookUpTable 	atanTable;
	private static int 			sinePrecisionLevel;	
	public static final String 	K_TABLE_FILEPATH = "./tables/KTable.txt";
	public static final String 	ATAN_TABLE_FILEPATH = "./tables/atanTable.txt";
	
	
	static {
		
		/*** CORDIC related operations ***/
		
		// Load up tables in memory.
		
		KTable = new LookUpTable(K_TABLE_FILEPATH);
		atanTable = new LookUpTable(ATAN_TABLE_FILEPATH);
		
		int KTableSize = KTable.getSize();
		int atanTableSize = atanTable.getSize();
		
		// Set size based on the minimum value between KTable and atanTable sizes.
		if (KTableSize > atanTableSize) {
			sinePrecisionLevel = atanTableSize;
		}
		else {
			sinePrecisionLevel = KTableSize;
		}
		
	}	
	
	
	
	/**
	 * 
	 * 
	 * @param
	 * @return
	 */
	public static double stdDeviation(List<Double> values) {
		 
		double valueSum = 0;
		double valueSumSquareDifference = 0;		
		double valueCount = 0;
		double valueAverage = 0;
		double standardDeviation = 0;
				
		// Calculates the average value
		
		for (double value : values) {
			valueSum += value;
			valueCount++;
		}
		
		valueAverage = valueSum / valueCount;

		// Calculates the Standard Deviation
		
		for(double value : values) {
			double valueSquareDifference = power((value - valueAverage),2);
			valueSumSquareDifference += valueSquareDifference;
		}	
	
		standardDeviation = power((valueSumSquareDifference / valueCount) , 0.5);
		
		return standardDeviation;
		
	}
	
	
	/**
	 * This method calculates the natural logarithm of x with precision 10^-n
	 * 
	 * @param value of x
	 * @return
	 */	
	public static double natLog(double x) {
		
		double y = 0;
		double m = 0;
		
		//If x<=0, return false because x should be positive real number
		
		if (x <= 0) {
			System.out.println("False and x should be positive number!");
		}
		
		//If 0<x<2, use Taylor series to compute ln(x) directly
		
		else if (x > 0 && x < 2) {
			
			double a = x - 1;
			for (int i = 1; i <= 1000; i++) {
				y = y + power(-1,i-1) * power(a,i) / i;
			}
		}
		
		//If x>=2, use x/e to map x to interval (0,2) and then compute ln(x)
		
		else {
			while (x >= 2) {
				m = m + 1;
				x = x / natExp(1);
			}
				double b = x - 1;
				for(int j=1; j <= 1000; j++) {
					y = y + power(-1,j-1) * power(b,j) / j;
				}
				y = y + m;
			}
		
		return y;
		
	}
	
	
	
	/**
	 * 
	 * 
	 * @param 
	 * @return 
	 */	
	public static double power(double base, double basePow) {

		if (basePow == 0) {
			return 1;
		} 
		if (basePow == 1) {
			return base;
		} 
		if (basePow > 1) {
			return base * power(base, basePow - 1);
		}

		return 1 / power(base, -1 * basePow);
	}

	
	
	/**
	 * This method calculates 10^x, using algorithm 10^x = e^(x*ln10)
	 * 
	 * @param value of x
	 * @return value of 10^x
	 */	
	public static double tenEx(double value) {
		
		return natExp(value * LN10);
		
	}
	
	
	/**
	 * Calculates the natural exponent with a Talyor series.
	 * 
	 * @param power
	 * @return
	 */
	public static double natExp(double power) {
		int NUMBER_OF_TERMS = 175;
		double result = 0;
		int powersOf2 = 0;
		
		while (power > 1) {
			power /= 2;
			powersOf2++;
		}
		
		
		for (int i = 0; i < NUMBER_OF_TERMS; i++) {
			result = result + (integerExp(power, i) / factorial(i));
		}
		
		while (powersOf2 > 0) {
			result *= result;
			powersOf2--;
		}
		
		return result;
	}
	

	
	/**
	 * This method calculates the sine value of an angle using the CORDIC algorithm
	 * 
	 * @param 	angle expressed in radiant
	 * @return 	sine value
	 */
	public static double sin(double angle) {

		int flip = 1;
		
		
		while ((angle < (-PI/2.0)) || (angle > (PI/2.0))) {
			flip = -flip;
			if (angle < 0) {
				angle = angle + PI;
			}
			else {
				angle = angle - PI;
			}
		}
		
		double x = 1.0;
		double y = 0.0;
		
		int sigma = 0;
		double xbuffer;
		
		int i;
		double factor = 1.0;
		for (i = 0; i < sinePrecisionLevel; i++) {
			
			// We can calculate sigma based on the angle.
			// Sigma will determine the direction of the rotation.
			
			if (angle < 0) {
				sigma = -1;
			}
			else {
				sigma = 1;
			}
			
			// Apply rotation.
			xbuffer = x + y * -(sigma * factor);
			y += (sigma * factor) * x;
			x = xbuffer;
			
			factor /= 2.0;
			
			// Update angle.
			angle = angle + (-sigma * atanTable.get(i));
			
		}
		
		y *= KTable.get(sinePrecisionLevel - 1); 
		return y * flip;
		
	}
	
	
/************************ PRIVATE METHODS ****************************/

	/**
	 * Gives absolute value of a double float.
	 * 
	 * @param n
	 * @return
	 */	
	public static double abs(double n) {
		if (n < 0)
			return -n;
		
		return n;
	}
	
	
	
	/**
	 * Returns the factorial of a given n.
	 * 
	 * @param n
	 * @return
	 */
	private static double factorial (int n) {
		assert n > 0: "Negative Factorial.";
		
		double result = 1;
		
		for (int i = n; i > 0; i--) {
			result *= i;
		}
		
		return result;
	}
	
	
	
	/**
	 * Returns a double to an integer power.
	 * 
	 * @param base
	 * @param power
	 * @return
	 */
	private static double integerExp(double base, int power) {
		
		assert power >= 0 : "Negative Power.";
		if (power == 0) {
			return 1;
		}
		if (power == 1) {
			return base;
		}
		if (power % 2 == 1) {
			return base * integerExp(base * base, power);
		}
		
		return integerExp(base * base, power / 2);
	}

	
	
}
