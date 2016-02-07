import java.util.LinkedList;
import java.util.List;

public class TenEx implements IAlgorithm {
	
	private static final double LN10 = 2.3025850929940457;
	
	//note: need to change method in IAlgorithm interface to static as well!
	//note 2 for refactoring: method names should not be capitalized
	
	public static double Calculate(List<Double> values){
		double number = values.get(0);
		double result = Math.exp(number * LN10);
		return result;
	}
	
	public static double Calculate2(List<Double> values){
		double number = values.get(0);
		//need to change naturalExp to public
		double result2 = NaturalExponential.naturalExp(number * LN10);
		return result2;
	}
	
	public static void main(String[] args){
		
		
		Double var1 = (double) 6.857;
		//Double var2 = (double) 2;
		Double expectedResult = (double) 7194489.780036994; //taken from a web scientific calc
		
		List<Double> values = new LinkedList<Double>();
		values.add(var1);
		//values.add(var2);
		System.out.println("number is " + values.get(0));
		double result = TenEx.Calculate(values);
		
		System.out.println("Actual result is " + result + " and expected result is " + expectedResult);
		
		System.out.println("And now using the natural exponent class");
		double result2 = TenEx.Calculate2(values);
		System.out.println("Actual result using homemade e^x method is "+ result);
		
	}
}
