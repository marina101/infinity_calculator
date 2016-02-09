
public class SquareRoot {
	
	public static long abs (long n) {
		if (n < 0)
			return -n;
		
		return n;
	}
	
	public static double abs(double n) {
		if (n < 0)
			return -n;
		
		return n;
	}

	
	public static double sqrt(double n) {
		if (n < 0)
			throw new NumberFormatException();
		
		final double PRECISION = 0.0000000001;
		double guess = 10;
		double next = 0;
		
		while (abs(guess - next) > PRECISION) {
			next = n / guess;
			guess = (guess + next) / 2;
		}
		
		return guess;
	}
	
	public static void main(String[] args) {
		double a = 1.5;
		final double PRECISION = 0.0000000001;
		
		for (int i = 0; i < 500; i++) {
			System.out.println(sqrt(a));
			long calStart = System.currentTimeMillis();
			double calculatedE = sqrt(a);
			long calElapsedTimeMillis = System.currentTimeMillis()-calStart;
			long javaStart = System.currentTimeMillis();
			double javaE = Math.sqrt(a);
			long javaElapsedTimeMillis = System.currentTimeMillis()-javaStart;
			long timeDiff = abs(calElapsedTimeMillis - javaElapsedTimeMillis);
			double difference = abs(calculatedE - javaE);
			
			if (difference < PRECISION) {
				System.out.println("Good. Difference is " + difference + " at " + i);
			} else {
				System.out.println("Bad. Difference is " + difference + " at " + i);
			}
			System.out.println("Time for calculcated sqrt is " + calElapsedTimeMillis);
			System.out.println("Time for java sqrt is " + javaElapsedTimeMillis);
			System.out.println("Difference is  " + timeDiff);
			
			a++;
		}
	}

}
