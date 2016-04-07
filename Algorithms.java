package com.example.user.calculatorv2;

/**
 * Created on 2016-02-22.
 * Algorithms written by: 
 * Christopher Birkbeck
 * Jerome Charriere
 * Marina Chirchikova
 * Ricardo Bezerra De Oliveira
 * Shuai Chen
 * Tarnum Sharma                          
 */
public class Algorithms {
    private static final double LN10 = 	2.3025850929940457;
    private static final double PI = 	3.14159265359;


    private static LookUpTable KTable;
    private static LookUpTable atanTable;
    private static int sinePrecisionLevel;




    static {

        /* CORDIC related operations */

        // Load up tables in memory.

        KTable = new LookUpTable("kt");
        atanTable = new LookUpTable("at");

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
     * This method calculates the square root of n.
     *
     * @param n - value of n
     * @return value of square root of n
     */
    public static double sqrt(double n) {
        if (n < 0) {
            throw new NumberFormatException();
        }

        final double PRECISION = 0.0000000001;
        double guess = 10;
        double next = 0;

        while (abs(guess - next) > PRECISION) {
            next = n / guess;
            guess = (guess + next) / 2;
        }

        return guess;
    }


    /**
     * This method calculates the natural logarithm of x with precision 10^-n
     *
     * @param x - value of x
     * @return value of 10^-n
     */
    public static double natLog(double x) throws MathException {

        double y = 0;
        double m = 0;

        //If x<=0, return false because x should be positive real number

        if (x <= 0) {
            throw new MathException("LN argument must be positive");
        }

        //If 0<x<2, use Taylor series to compute ln(x) directly

        else if (x > 0 && x < 2) {

            double a = x - 1;
            for (int i = 1; i <= 1000; i++) {
                y = y + integerPower(-1, i-1) * integerPower(a, i) / i;
            }
        }

        //If x>=2, use x/e to map x to interval (0,2) and then compute ln(x)

        else {
            while (x >= 2) {
                m = m + 1;
                x = x / natExp(1);
            }
            double b = x - 1;
            for (int j = 1; j <= 1000; j++) {
                y = y + integerPower(-1, j-1) * integerPower(b, j) / j;
            }
            y = y + m;
        }

        return y;

    }



    /**
     * This method raises x to the power of y.
     *
     * @param x = value of x
     * @param y = value of y
     * @return value of x^y
     */
    public static double power(double x, double y) throws MathException {

        double a = 1;
        double sum = 1;
        double i = 1;

        if (y == 0) {
            if (x < 0) {
                return -1;
            }
            return 1;
        }

        if (x == 0) {

            if (y < 0) {
                // Return an error.
            }

            if (y == 0) {
                return 1;
            }

            return 0;

        }


        // When power < 0, we return 1 / power(x, -y).

        if (y < 0) {
            return 1 / power(x, -y);
        }

        double j = natLog(x) * y;

		/* 
		 *Using Taylor Series to implement x^y
		 * x^y = 1 + (lnx)y + (((lnx)^2)y^2)/2! + ..... + (((lnx)^n)y^n)/n!
		 * j = (lnx)y
		 */

        while (a > 1e-15) {
            a = a * j / i;
            sum = sum + a;
            i++;
        }

        // Using optimization method to get approximate result.
        double s = sum % 1;

        if (s > 0.999999999){
            sum = sum - s + 1;
        }
        else if (s < 0.000000001){
            sum = sum - s;
        }

        return sum;
    }



    /**
     * This method calculates 10^x, using algorithm 10^x = e^(x*ln10)
     *
     * @param value of x
     * @return value of 10^x
     */
    public static double tenEx(double value) throws MathException {


            return power(10, value);


    }



    /**
     * Finds the natural exponent of a double.
     *
     * @param power = value of power
     * @return value of e^power
     */
    public static double exp(double power) {
        if (power < 0) {
            power = -power;
            return 1 / natExp(power);
        }

        return natExp(power);
    }




    /**
     * This method calculates the sine value of an angle using the CORDIC algorithm
     *
     * @param 	angle = value of angle expressed in radiant
     * @return 	sine value of angle
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


    /* PRIVATE METHODS */

    /**
     * This method gives the absolute value of a double float.
     *
     * @param n = value of n
     * @return absolute value of n
     */
    private static double abs(double n) {
        if (n < 0)
            return -n;

        return n;
    }



    /**
     * This method returns the factorial of a given n.
     *
     * @param value of n
     * @return factorial value of n
     */
    public static double factorial(int n)  {
        assert n > 0: "Negative Factorial.";



        double result = 1;

        for (int i = n; i > 0; i--) {
            result *= i;
        }

        return result;
    }



    /**
     * This method returns a double to an integer power.
     *
     * @param value of base
     * @param value of power
     * @return value of base^power
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
            return base * integerExp(base * base, (power - 1)/2);
        }

        return integerExp(base * base, power / 2);
    }



    /**
     * This method calculates the natural exponent with a Taylor series.
     *
     * @param power
     * @return value of the natural exponent of power.
     */
    private static double natExp(double power)  {
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
     * This method raises x to the power y but only accept integer based power values.
     *
     * @param value of x
     * @param value of y
     * @return x^y
     */
    private static double integerPower(double x, int y) {
        if (y == 0) {
            return 1; // When base-power is zero the output will be one
        }
        if (x == 0) {
            return 0; // When base- number is zero the output will be zero
        }
        if (y < 0)  {
            return 1 / integerPower(x, -y); // Handling the negative power
        }

        return x * integerPower(x, y - 1);
    }
}
