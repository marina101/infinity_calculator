package xpowy;

import java.util.Scanner;

public class main {
	// main class
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the base number: ");
		double x = input.nextInt();// base-number

		System.out.print("Enter the base power: ");
		double y = input.nextInt();// base-power

		power access = new power();

		System.out.print(x + " to the power of " + y + " is: " + access.power(x, y));

	}

	public static class power {
		public double power(double x, double y) {
			if (x == 0) return 0; // when base- number is zero the output will be zero
			if (y == 0) return 1; // when base-power is zero the output will be one 
			if(y<0) return 1/power(x, -y); // handling the negative power
			return x * power(x, y - 1);
			}
	}



}