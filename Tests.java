import static org.junit.Assert.*;
import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		
		/* We specify an error margin for each of the test functions.
		 * 
		 * The error margins chosen demonstrate the precision limits of each of the functions. 
		 * Anything beyond those values will trigger a test failure. 
		 */
		
		testSin(	0.000000000001);
		testExp(	0.00000000000001);
		testPower(	0.00000000000001);
		testTenEx(	0.00000000001);
		testNatLog(	0.00000000001);
		testSqrt(	0.0000000001);
		
	}
	
	
	public void testSin(double delta) {
					
		assertEquals(Math.sin(0), 					Algorithms.sin(0), 	delta);
		assertEquals(Math.sin(Math.PI), 			Algorithms.sin(Math.PI), 	delta);
		
	}
	
	public void testExp(double delta) {
		
		assertEquals(Math.exp(0), 							Algorithms.exp(0), 	delta);		
		assertEquals(Math.exp(Math.E), 						Algorithms.exp(Math.E), 	delta);

		
	}
	
	public void testPower(double delta) {
		
		assertEquals(Math.pow(0, 0), 						Algorithms.power(0, 0), 	delta);
		assertEquals(Math.pow(Math.sqrt(6), Math.sqrt(2)), 	Algorithms.power(Math.sqrt(6), Math.sqrt(2)), 	delta);
		
	}
	
	public void testTenEx(double delta) {
		
		assertEquals(Math.pow(10, 0), 				Algorithms.tenEx(0), 	delta);
		assertEquals(Math.pow(10, Math.PI), 		Algorithms.tenEx(Math.PI), 	delta);
		
	}
	
	public void testNatLog(double delta) {
		
		assertEquals(Math.log(543), 			Algorithms.natLog(543), 	delta);
		assertEquals(Math.log(Math.E), 			Algorithms.natLog(Math.E), 	delta);
		
	}
	
	
	public void testSqrt(double delta) {

		assertEquals(Math.sqrt(0), 				Algorithms.sqrt(0), delta);
		assertEquals(Math.sqrt(Math.E), 		Algorithms.sqrt(Math.E), delta);
		
	}
	
	
}
