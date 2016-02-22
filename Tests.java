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
		testExp(	0.00000000001);
		testPower(	0.00000000000001);
		testTenEx(	0.00001);
		testNatLog(	0.0000000001);
		testSqrt(	0.0000000001);
		
	}
	
	
	public void testSin(double delta) {
					
		assertEquals(0.0, 					Algorithms.sin(0.0), 	delta);
		assertEquals(-0.9880316240928618, 	Algorithms.sin(30.0), 	delta);
		
	}
	
	public void testExp(double delta) {
		
		assertEquals(1, 							Algorithms.exp(0), 	delta);		
		assertEquals(2980.9579870417283, 			Algorithms.exp(8), 	delta);

		
	}
	
	public void testPower(double delta) {
		
		assertEquals(1.0, 				Algorithms.power(0.0, 0.0), 	delta);
		assertEquals(22.54218602980021, Algorithms.power(2.5, 3.4), 	delta);
		
	}
	
	public void testTenEx(double delta) {
		
		assertEquals(1.0, 				Algorithms.tenEx(0.0), 	delta);
		assertEquals(1000000000, 		Algorithms.tenEx(9.0), 	delta);
		
	}
	
	public void testNatLog(double delta) {
		
		assertEquals(6.2971093199, 			Algorithms.natLog(543), 	delta);
		assertEquals(3.4011973816621555, 	Algorithms.natLog(30.0), 	delta);
		
	}
	
	
	public void testSqrt(double delta) {

		assertEquals(0, 				Algorithms.sqrt(0), delta);
		assertEquals(1.224744871391589, Algorithms.sqrt(1.5), delta);
		
	}
	
	
}
