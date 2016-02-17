import static org.junit.Assert.*;
import org.junit.Test;


/**
 * This class is for calculating the value of 10^x using the algorithm 10^x = e^(x*ln10)
 * It does not rely on the java.math class, but instead only uses methods created for this project
 * It effectively calculates 10^x with 6 decimals of precision
 * @author Marina Chirchikova
 *
 */
public class TenEx{ //note I took away "implements IA" for now since now my
	//method only takes one double value, which is different from IA
	
	private static final double LN10 = 2.3025850929940457;
	
	//preconditions: -assumes method in IAlgorithm interface is static
	//				 -assumes naturalExp method is public
	//				-takes only one double
	
	/**
	 * This method calculates 10^x, using algorithm 10^x = e^(x*ln10)
	 * @param value of x
	 * @return value of 10^x
	 */
	public static double Calculate(double value){
		double result = NaturalExponential.naturalExp(value * LN10);
		return result;
	}
	
	//these test compares the value coming from the calculate method with the 
	//values that webcalculator 2.0 gives
	@Test
	public void testZero(){
		//testing when value is 0
		assertEquals(1, Calculate(0), 0.0);
	}
	
	@Test
	public void testNumber(){
		//testing when value is 6.857, if precision is <= 6 decimal points, the test passes
		assertEquals(7194489.780037, Calculate(6.857), 0.000001);
	}
	 
}

