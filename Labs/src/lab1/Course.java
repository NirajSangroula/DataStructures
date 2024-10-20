/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 1
Any and all work in this file is my own.
*/
package lab1;

public class Course {
	//Data members
	private final int MAX_ENROLLED_STUDENTS = 5;
	private Student[] students;
	private int enrollment;
	private Instructor instructor;
	private String code;
	private String name;
	
	//Constructor initializes array
	public Course(){
		students = new Student[MAX_ENROLLED_STUDENTS];
		enrollment = 0;
	}
	
	//Getters and Setters
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//enroll method, adds a student to an array and increase enrollment count
	public void enroll(Student student) {
		students[enrollment++] = student; //Use enrollment count as an index, then increase the value
	}
	
	//unenroll method removes the student if students array is not empty and has that student id.
	public void unenroll(Student student) {
		//If there students enrolled and it contains the student
		if(enrollment > 0 && isEnrolled(student)) {
			//We find at which point (index i), the removal student id is...
			for(int i = 0; i < enrollment; i++) {
				if(students[i].id() == student.id()) {
					//Now, i is the index of student to be removed
					//We will replace the student at i position(To be removed) by the student in LAST POSITION of array (enrollment - 1) index
					//We then set last position of array null
					/**
					 * 
					 * For example,
					 * Suppose the students in array are
					 * James, Hari, Williams, John
					 * 
					 * If Hari is to be removed, the array will be
					 * James, John, Williams, null
					 * 					 * 
					 * Because, We don't want null values in middle of an array
					 */
					
					Student lastStudent = students[enrollment - 1];
					students[enrollment - 1] = null;
					students[i] = lastStudent;
					
					//Decrease enrollment
					enrollment--;
				}
			}
		}
	}

	//isEnrolled method, to check if a student is enrolled in the course
	public boolean isEnrolled(Student student) {
		//iterate through each student, if any id match, student is enrolled otherwise not
		for(int i = 0; i < enrollment; i++) {
			if(students[i].id() == student.id())
					return true;
		}
		return false;
	}
	//NOTE: This method requires that you to have already entered grade for the student once 
	//Because it could do (0 + grade ) / 2 and average will be wrong in the first run.
	
	public void assignGrade(Student student, double grade) {
		for(int i = 0; i < enrollment; i++) {
			//Find the student in an array by matching id
			if(students[i].id() == student.id()) {
				students[i].setAverage((students[i].getAverage() + grade) / 2);
			}
		}
	}
	
	@Override
	public String toString() {
		//Print instructor name only if it is assigned
		return "Course[code=" + code + ", name=" + name + ", instructor=" + ((instructor==null)?"":instructor.name()) + ", enrolled=" + enrollment + "]";
	}
}
