
public class Exp {
	
	final static double E = 2.7182818284590;
	final static int NUMBER_OF_TERMS = 50;
	
	public static double intExp(double base, int exp) {
		if (exp < 0)
			throw new NumberFormatException();
		if (exp == 0)
			return 1;
		if (exp == 1)
			return base;
		if (exp % 2 != 0) 
			return base * intExp(base * base, (exp - 1) / 2);
		
		return intExp(base * base, (exp)/2);
	}
	
	public static double factorial(int n) {
		if (n < 0)
			throw new NumberFormatException();
		if (n == 0)
			return 1;
		
		double result = 1;
		
		for (int i = n; i > 0; i--) {
			result *= i;
		}
		
		return result;
	}
	
	public static double exp(double exponent) {
		int powersOf2 = 0;
		
		while (exponent > 2) {
			exponent /= 2;
			powersOf2++;
		}
		
		int wholeNumber = (int)exponent;
		double fractional = exponent - wholeNumber;
		assert fractional < 1 : "Fractional greater than 1";
		
		double result = 0;
		double fractionalResult = 0;
		
		result = Exp.intExp(E, wholeNumber);
		
		for (int i = 0; i < NUMBER_OF_TERMS; i++) {
			fractionalResult = fractionalResult + intExp(fractional, i)/factorial(i);
		}
		
		result = result * fractionalResult;
		
		while (powersOf2 > 0) {
			result *= result;
			powersOf2--;
		}
		
		return result;
	}

	public static void main(String[] args) {
		double testExp = 1.0;
		
		for (int i = 0; i < 50; i++) {
			double javaE = Math.exp(testExp);
			double testE = Exp.exp(testExp);
			double difference = Math.abs(testE - javaE);
			
			System.out.println("e^" + testExp + " = " + testE);
			
			switch (i) {
			case 10:
				testExp = 10;
				break;
			case 20:
				testExp = 20;
				break;
			case 30:
				testExp = 30;
				break;
			case 40:
				testExp = 40;
				break;
			default:
				break;	
			}
			
			if (difference < 0.00003)
				System.out.println("Good. Difference is " + difference);
			else
				System.out.println("Bad. Difference is " + difference);
			testExp++;
		}

	}

}
