package xpowy;

import static org.junit.Assert.*;

import org.junit.Test;

public class powtest {

	@Test
	public void test() {
		//public void test_nominator_nonzero_denominator_zero() {
			   powtest mathObject = new powtest();
			   assertFalse("0 can't be a divisor of a non-zero number", mathObject(0, 5));
			}

	private boolean mathObject( int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}
}
