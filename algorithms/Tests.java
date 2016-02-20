import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		
		double errorMargin = 0.000000003;
		
		testSin(errorMargin);
		testNatExp(errorMargin);
		testPower(errorMargin);
		testTenEx(errorMargin);
		testNatLog(errorMargin);
		testStdDeviation(errorMargin);
		
	}
	
	
	public void testSin(double delta) {
					
		assertEquals(0.0, 			Algorithms.sin(0.0), 	delta);
		assertEquals(-0.98803162, 	Algorithms.sin(30.0), 	delta);
		
	}
	
	public void testNatExp(double delta) {
		
		assertEquals(0.0, 			Algorithms.natExp(0.0), 	delta);

		
	}
	
	public void testPower(double delta) {
		
		assertEquals(1.0, 				Algorithms.power(0.0, 0.0), 	delta);
		assertEquals(197798520.1462557, Algorithms.power(3.3, 16.0), 	delta);
		
	}
	
	public void testTenEx(double delta) {
		
		assertEquals(1.0, 				Algorithms.tenEx(0.0), 	delta);
		assertEquals(1000000000, 		Algorithms.tenEx(9.0), 	delta);
		
	}
	
	public void testNatLog(double delta) {
		
		assertEquals(0.0, 			Algorithms.natLog(0.0), 	delta);
		assertEquals(3.401197382, 	Algorithms.natLog(30.0), 	delta);
		
	}
	
	
	public void testStdDeviation(double delta) {
		
		
		double var1 = (double) 10;
		double var2 = (double) 20;
		double var3 = (double) 34;
		double var4 = (double) 56;
		double var5 = (double) 76;
		double var6 = (double) 54;
		
		List<Double> values = new LinkedList<Double>();
		values.add(var1);
		values.add(var2);
		values.add(var3);
		values.add(var4);
		values.add(var5);
		values.add(var6);
		
		assertEquals(22.61, Algorithms.stdDeviation(values), delta);
		
	}
	
	
}
