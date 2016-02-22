import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LookUpTable {
	
	private static final int MAX_ITEMS = 128;
	
	private double[] 	items;
	private int			size;

	
	public LookUpTable(String filePath) {
		items = new double[MAX_ITEMS];
					
		BufferedReader reader = null;
		
		
		try {
			reader = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			System.err.println("Error: table file '" + filePath + "' not found.");
		}
		
		String line = "";
				
		int i;
		try {
			for (i = 0; ((line = reader.readLine()) != null); i++) {
				
				if (i == MAX_ITEMS) {
					break;					
				}
				
				items[i] = Double.parseDouble(line);
				
			}
			
			size = i;
			
		} catch (NumberFormatException e) {
			System.err.println("Error: table '" + filePath + "' contains an invalid element.");
		} catch (IOException e) {
			System.err.println("Error: unable to read from table file'" + filePath + "'.");
		}
		
		try {
			reader.close();
		} catch (IOException e) {
			System.err.println("Error: unable to close table file '" + filePath + "'.");
		}		
		
	}
	
	// Returns the element at index i in the table.
	public double get(int i) {
		
		if (i > (size-1)) {
			System.err.println("Error: index for lookup table too large.");
			return 0;
			
		}
		return items[i];
	}
	
	// Returns the number of elements stored within the table.
	public int getSize() {
		
		return size;
		
	}
	
	
}
