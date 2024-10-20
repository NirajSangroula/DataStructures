package stack;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import assignment4.e1.ReferenceStack;
import assignment4.e1.StackException;

public class StackTest {

	public static void main(String[] args) {
		try {
			ReferenceStack s = new ReferenceStack();
			s.push("Niraj");
			s.push(453);
			s.push(434.4534);
			System.out.println(s.pop());
			System.out.println(s.isEmpty());
			System.out.println(s.peek());
			s.push("sth");
			System.out.println(s.peek());
			s.popAll();
			System.out.println(s.peek());
			StringBuilder sb = new StringBuilder();
			StringBuffer sbb = new StringBuffer();
		}
		catch(StackException e) {
			System.out.println(e.getMessage());
		}

	}

}
