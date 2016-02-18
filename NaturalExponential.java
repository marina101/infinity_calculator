
public class NaturalExponential {
	
	final static double E = 2.718281828459045;
	
	/**
	 * Gives absolute value of an int.
	 * 
	 * @param n
	 * @return
	 */
	public static int abs(int n) {
		if (n < 0)
			return -n;
		
		return n;
	}
	
	/**
	 * Gives absolute value of a double.
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
	 * Returns a double to an integer power.
	 * 
	 * @param base
	 * @param power
	 * @return
	 */
	private static double integerExp(double base, int power) {
		assert power >= 0 : "Negative Power.";
		if (power == 0)
			return 1;
		if (power == 1)
			return base;
		
		if (power % 2 == 1)
			return base * integerExp(base * base, (power - 1)/2);
		
		return integerExp(base * base, power / 2);
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
	 * Calculates the natural exponent with a Talyor series.
	 * 
	 * @param power
	 * @return
	 */
	private static double naturalExp(double power) {
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
	 * Finds the natural exponent of a double.
	 * 
	 * @param power
	 * @return
	 */
	public static double exp(double power) {
		if (power < 0) {
			power = -power;
			return 1 / naturalExp(power);
		}
		
		return naturalExp(power);
	}
	


}
