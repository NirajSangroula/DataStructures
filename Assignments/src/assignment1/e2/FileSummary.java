package assignment1.e2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileSummary {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(new File("salary.txt"))){
			String[][] names = new String[10][2];
			String[] ranks = new String[10];
			double[] salaries = new double[10];
			
			for(int i = 0; i < 10 && scanner.hasNext(); i++) {
				names[i][0] = scanner.next();
				names[i][1] = scanner.next();
				ranks[i] = scanner.next();
				salaries[i] = scanner.nextDouble();
			}

			double sumAssistantSalary = 0;
			double sumAssociateSalary = 0;
			double sumFullSalary = 0;
			int assistantCount = 0;
			int associateCount = 0;
			int fullCount = 0;
			
			for(int i = 0; i < 10; i++) {
				if(ranks[i].equals("Assistant")) {
					sumAssistantSalary += salaries[i];
					assistantCount++;
				}
				else if(ranks[i].equals("Associate")) {
					sumAssociateSalary += salaries[i];
					associateCount++;
				}
				else if(ranks[i].equals("Full")) {
					sumFullSalary += salaries[i];
					fullCount ++;
				}	
			}
			
			System.out.println("Total sum of assistant professors salary : " + sumAssistantSalary);
			System.out.println("Total sum of associate professors salary : " + sumAssociateSalary);
			System.out.println("Total sum of full professors salary : " + sumFullSalary);
			System.out.println("Total sum of faculty salary : " + (sumAssistantSalary + sumAssociateSalary + sumFullSalary));

			System.out.println("Average of assistant professors salary : " + sumAssistantSalary / assistantCount);
			System.out.println("Average of associate professors salary : " + sumAssociateSalary / associateCount);
			System.out.println("Average of full professors salary : " + sumFullSalary / fullCount);
			System.out.println("Average of faculty salary : " 
			+ (sumAssistantSalary + sumAssociateSalary + sumFullSalary) / (assistantCount + associateCount + fullCount));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
