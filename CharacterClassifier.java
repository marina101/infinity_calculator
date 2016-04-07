package com.example.user.calculatorv2;

/**
 * Provides static methods to check if a character is part of predefined sets of characters.
 * 
 * @author Jerome Charriere
 *
 */

public class CharacterClassifier {

	
	private static char digits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	private static char letters[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	
	
	/**
	 * Helper method.
	 * Checks if a character is within a character array.
	 * 
	 * @param c The target character to find within the array.
	 * @param array A sequence of characters.
	 * @return True if the character has been found inside the array. False otherwise.
	 */
	private static boolean isIn(char c, char array[]) {
		
		int i;
		for (i = 0; i < array.length; i++) {
			if (array[i] == c) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
	/**
	 * Checks if a character is a digit.
	 * 
	 * @param c Character to check.
	 * @return True if the character is a digit. False otherwise.
	 */
	public static boolean isDigit(char c) {
		
		if (isIn(c, digits)) {
			return true;
		}
		
		return false;
		
	}
	
	
	
	/**
	 * Checks if a character is a letter.
	 * 
	 * @param c Character to check.
	 * @return True if the character is a letter. False otherwise. 
	 */
	public static boolean isLetter(char c) {
		
		if (isIn(c, letters)) {
			return true;
		}
		
		return false;
	}
	
	
}
