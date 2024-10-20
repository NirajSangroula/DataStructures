package assignment1.e2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileCreate {

	public static void main(String[] args) {
		String names[][] = new String[][]{
			new String[]{"Niraj", "Sangroula"},
			new String[]{"Aashis", "Bhatta"},
			new String[]{"Aakash", "Khatri"},
			new String[]{"Dipan", "Bhusal"},
			new String[]{"Ankit", "Neupane"},
			new String[]{"Uma_Shankar", "Bind"},
			new String[]{"Dipesh", "Khatiwada"},
			new String[]{"Pramod", "Kharel"},
			new String[]{"Narayan_Gopal", "Guruwacharya"},
			new String[]{"Nitesh", "Sangroula"},
		};
		
		try (PrintWriter writer = new PrintWriter("salary.txt")){
			for(int i = 0; i < 10; i++) {
				String rank = getRandomRank();
				double salary = getSalaryOfRank(rank);
				writer.print(names[i][0] + " ");
				writer.print(names[i][1] + " ");
				writer.print(rank + " ");
				writer.println(salary);
			}
			System.out.println("File created!");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static String getRandomRank() {
		int number = (int)(Math.random() * 3);
		switch(number) {
		case 0: return "Assistant";
		case 1: return "Associate";
		default: return "Full";
		}
	}

	private static double getSalaryOfRank(String rank) {
		switch(rank) {
			case "Assistant" : return getSalaryInRange(50_000, 80_000);
			case "Associate" : return getSalaryInRange(60_000, 110_000);
			default: return getSalaryInRange(75_000, 130_000);
		}
	}
	private static double getSalaryInRange(double a, double b) {
		double salary = Math.random() * (b - a) + a;
		int temp = (int)(salary * 100);
		return temp / 100d;
	}
}
