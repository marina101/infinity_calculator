
public class NaturalExponential {
	
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
		assert power >= 0 : "Negative Power ";
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
	public static double factorial (int n) {
		if (n < 0)
			throw new NumberFormatException();
		
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
		int numberOfTerms = 100;
		double result = 0;
		int powersOf2 = 0;
		
		while (power > 10) {
			power /= 2;
			powersOf2++;
		}
			
		for (int i = 0; i < numberOfTerms; i++) {
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
	
	public static void main(String[] args) {
		double a = -10;
		final double PRECISION = 0.0000000001;
		
		for (int i = 0; i < 50; i++) {
			long startTime = System.nanoTime();
			double calculatedE = exp(a);
			double javaE = Math.exp(a);
			double difference = Math.abs(calculatedE - javaE);
			
			if (difference < PRECISION) {
				System.out.println("Good. Difference is " + difference + " at " + a);
			} else {
				System.out.println("Bad. Difference is " + difference + " at " + a);
			}
			
			switch(i) {
			case 10:
				a = 1.0;
				break;
			case 20:
				a = 11.0;
				break;
			case 30:
				a = 21.0;
				break;
			case 40:
				a = 31.0;
				break;
			default:
				a++;
			}
			long endTime = System.nanoTime();
			System.out.println(((endTime - startTime)));
		}
		
	}

}
