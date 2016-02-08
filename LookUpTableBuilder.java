package edu.Concordia.Eternity.Tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import edu.Concordia.Eternity.Algorithm.Sin;

public class LookUpTableBuilder {
	
	private static final int N_ITEMS = 50;
	
	private static BufferedWriter setupWriter(String filePath) {
		
		File file = new File(filePath);

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		FileWriter fw = null;
		try {
			fw = new FileWriter(file.getAbsoluteFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new BufferedWriter(fw);
		
		
	}
	
	private static void buildKTableFile(int nItems) {
		
		BufferedWriter bw = setupWriter(Sin.K_TABLE_FILEPATH);
		
		double accumulator = 1;
		
		int i;
		String nl = ""; 
		for (i = 0; i < nItems; i++) {
			
			if (i == 1) {
				nl = "\r\n";
			}
			
			accumulator *= (1.0 / Math.sqrt(1.0 + Math.pow(2.0, -2.0*i)));
			
			try {
				bw.write(nl + Double.toString(accumulator));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static void buildAtanTableFile(int nItems) {
		
		BufferedWriter bw = setupWriter(Sin.ATAN_TABLE_FILEPATH);
		
		double value;
		int i;
		String nl = ""; 
		for (i = 0; i < nItems; i++) {
			
			if (i == 1) {
				nl = "\r\n";
			}
			
			value = Math.atan(Math.pow(2, -i));
			
			try {
				bw.write(nl + Double.toString(value));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String args[]) {
		
		System.out.println("creating K Table..");
		buildKTableFile(N_ITEMS);
		System.out.println("creating atan Table..");
		buildAtanTableFile(N_ITEMS);
		
		System.out.println("tables creation successful!");
		
		
	}
	
	
}
