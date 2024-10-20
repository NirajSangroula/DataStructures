package assignment1.e1;

import java.util.Date;
import java.util.Scanner;

import assignment1.e1.Triangle.IllegalTriangleException;

public class Test {
	public static void main(String[] args) {
		//Prompt user input
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter three sides, color and filled status (true/false)");
		Triangle t1;
		try {
			t1 = new Triangle(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.next(), sc.nextBoolean(), new Date());
			System.out.println("Triangle properties");
			System.out.println(t1);
			System.out.println("Perimeter : " + t1.getPerimeter());
			System.out.printf("Area : %.2f\n", t1.getArea());
			System.out.println("Color : " + t1.getColor());
			System.out.println("Filled : " + t1.isFilled());
		} catch (IllegalTriangleException e) {
			System.out.println(e.getMessage());
		}
	}
}
