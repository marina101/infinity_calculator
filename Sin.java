package edu.Concordia.Eternity.Algorithm;

import java.util.List;

import edu.Concordia.Eternity.Interface.*;
import edu.Concordia.Eternity.Tools.LookUpTable;


public class Sin implements IAlgorithm {
	
	private static LookUpTable KTable;
	private static LookUpTable atanTable;
	
	private static int precisionLevel;
	
	public static final String K_TABLE_FILEPATH = "./Tables/KTable.txt";
	public static final String ATAN_TABLE_FILEPATH = "./Tables/atanTable.txt";
	
	private static final double PI = 3.14159265359;
	
	static {
		
		// Load up tables in memory.
		
		KTable = new LookUpTable(K_TABLE_FILEPATH);
		atanTable = new LookUpTable(ATAN_TABLE_FILEPATH);
		
		int KTableSize = KTable.getSize();
		int atanTableSize = atanTable.getSize();
		
		// Set size based on the minimum value between KTable and atanTable sizes.
		if (KTableSize > atanTableSize) {
			precisionLevel = atanTableSize;
		}
		else {
			precisionLevel = KTableSize;
		}
		
	}
	
	
	public Sin() {
		
		
	}
	
	
	public double Calculate(List<Double> values) {

		double angle = values.get(0);
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
		for (i = 0; i < precisionLevel; i++) {
			
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
		
		y *= KTable.get(precisionLevel - 1); 
		return y * flip;
		
	}
}
