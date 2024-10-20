package assignment1.e1;

import java.util.Date;

public class Triangle extends GeometricObject {
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle() {
		side1 = side2 = side3 = 1;
	}
	
	public Triangle(double s1, double s2, double s3, String color, boolean filled, Date dateCreated) throws IllegalTriangleException{
		super(color, filled, dateCreated);
		if (side1 >= side2 + side3 || side2 >= side1 + side3 || side3 >= side1 + side2)
			throw new IllegalTriangleException();
		side1 = s1;
		side2 = s2;
		side3 = s3;
		
	}
	
	public Triangle(double s1, double s2, double s3) throws IllegalTriangleException{
		if (side1 >= side2 + side3 || side2 >= side1 + side3 || side3 >= side1 + side2)
			throw new IllegalTriangleException();
		side1 = s1;
		side2 = s2;
		side3 = s3;
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}
	
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	
	public double getArea() {
		double s = getPerimeter() / 2;
		double param = s * (s - side1) * (s - side2) * (s - side3);
		double area = Math.sqrt(param);
		return area;
	}
	
	@Override
	public String toString() {
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}
	
	public class IllegalTriangleException extends Exception {
		public IllegalTriangleException() {
			super("Sum of two sides of triangle should be greater than third one");
		}
	}

}
