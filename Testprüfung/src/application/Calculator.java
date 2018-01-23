package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Calculator {
		
	Queue<String> history; 
	
	private static final String DATA_FILE = "history.txt";
	
	public Calculator() {
		history = new LinkedList<>(); 
		File f = new File(DATA_FILE);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		loadHistoryFromFile();
		
	}
	
	private void loadHistoryFromFile() {
		Scanner in;
		try {
			in = new Scanner(new File(DATA_FILE));
			while (in.hasNextLine()) {
			history.add(in.nextLine());
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	private void saveHistory() {
		try (PrintWriter out = new PrintWriter(new FileOutputStream(DATA_FILE))) {
			for (String s : history) {
				out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error: " + e);
		}
	}
	
	public int add(int operand1, int operand2) { 
		int result = operand1 + operand2;
		if (history.size() >= 5) {
			history.poll();
		}
		history.add(String.format("%d + %d = %d", operand1, operand2, result));
		this.saveHistory();
		return result;
	}
	
	public int subtract(int operand1, int operand2) {
		int result = operand1-operand2; 
		if (history.size() >= 5) {
			history.poll();
		}
		history.add(String.format("%d - %d = %d", operand1, operand2, result));
		this.saveHistory();
		return result;
	}
	
	public int multiply(int operand1, int operand2) {
		int result =  operand1 * operand2; 
		if (history.size() >= 5) {
			history.poll();
		}
		history.add(String.format("%d * %d = %d", operand1, operand2, result));
		this.saveHistory();
		return result;
	}
	
	public int divide(int operand1, int operand2) throws DivisionByZeroException {
		if (operand2 == 0) throw new DivisionByZeroException();
		int result = operand1 / operand2;
		if (history.size() >= 5) {
			history.poll();
		}
		history.add(String.format("%d * %d = %d", operand1, operand2, result));
		this.saveHistory();
		return result;
	}
	
	public Queue<String> getHistory() {
		return this.history;
	}	
}
