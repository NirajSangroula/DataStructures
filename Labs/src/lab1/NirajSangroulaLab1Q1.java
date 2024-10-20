/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 1
Any and all work in this file is my own.
*/

package lab1;

public class NirajSangroulaLab1Q1 {

	public static void main(String[] args) {
		try {
			//Create 7 students
			Student s1 = new Student(1, "Niraj Sangroula");
			Student s2 = new Student(2, "Ram Yadhav");
			Student s3 = new Student(3, "Pranisha Xettri");
			Student s4 = new Student(4, "Aakash Khatri");
			Student s5 = new Student(5, "Dipan Bhusal");
			Student s6 = new Student(6, "Aashis Bhatta");
			Student s7 = new Student(7, "Uma Shankar Bind");
			//Print all students
			System.out.println("All students detail:");
			System.out.println(s1);			
			System.out.println(s2);			
			System.out.println(s3);			
			System.out.println(s4);			
			System.out.println(s5);			
			System.out.println(s6);			
			System.out.println(s7);		
			
			//Create an instructor
			System.out.println("\nInstructor: ");
			Instructor i1 = new Instructor(559, "Dipak Pudasaini", "Data Structures");
			System.out.println(i1);
			
			//Create 2 courses
			Course c1 = new Course();
			c1.setCode("COSC1234");
			c1.setName("COSC course 1");
			Course c2 = new Course();
			c2.setName("COSC course 2");
			c2.setCode("COSC2345");
			
			//Assign students to the courses
			c1.enroll(s1);
			c1.enroll(s2);
			c1.enroll(s3);
			c1.enroll(s4);
			c1.enroll(s5);

			c2.enroll(s6);
			c2.enroll(s7);
			
			System.out.println("\nCourses details");
			System.out.println(c1);
			System.out.println(c2);
			
			//Set student averages
			s1.setAverage(100);
			s2.setAverage(43);
			s3.setAverage(60);
			s4.setAverage(20);
			s5.setAverage(89);
			s6.setAverage(65);
			s7.setAverage(66);

			//Print all students after average entered
			System.out.println("\nAll students detail after average entered:");
			System.out.println(s1);			
			System.out.println(s2);			
			System.out.println(s3);			
			System.out.println(s4);			
			System.out.println(s5);			
			System.out.println(s6);			
			System.out.println(s7);	
			
			//Assign instructor to both courses
			c1.setInstructor(i1);
			c2.setInstructor(i1);
			
			//Print course details
			System.out.println("\nAfter assigning instructor, course details:");
			System.out.println(c1);
			System.out.println(c2);
			
			//Unenroll 2 students from course 1
			c1.unenroll(s2);
			c1.unenroll(s4);
			
			System.out.println("\nAfter unenrolling 2 students, course details:");
			System.out.println(c1);
			System.out.println(c2);
			
			//Assign all students grades
			c1.assignGrade(s1, 99);
			c1.assignGrade(s2, 34);
			c1.assignGrade(s3, 59);
			c1.assignGrade(s4, 87);
			c1.assignGrade(s5, 45);
			
			c2.assignGrade(s6, 76);
			c2.assignGrade(s7, 52);
			
			System.out.println("\nAfter assigning grades to courses of the students, their details: ");
			System.out.println(s1);			
			System.out.println(s2);			
			System.out.println(s3);			
			System.out.println(s4);			
			System.out.println(s5);			
			System.out.println(s6);			
			System.out.println(s7);	
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
