package com.example.user.calculatorv2;

public class CharacterClassifier {

	
	private static char digits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	private static char letters[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	
	private static boolean isIn(char c, char array[]) {
		
		int i;
		for (i = 0; i < array.length; i++) {
			if (array[i] == c) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static boolean isDigit(char c) {
		
		if (isIn(c, digits)) {
			return true;
		}
		
		return false;
		
	}
	
	public static boolean isLetter(char c) {
		
		if (isIn(c, letters)) {
			return true;
		}
		
		return false;
	}
	
	
}
