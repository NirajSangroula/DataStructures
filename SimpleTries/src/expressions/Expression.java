package expressions;

import java.util.Stack;

public class Expression {
	String infix;
	String postfix;
	double result;
	double[] operands;
	public Expression(String infixExpression, double[] operands) {
		this.infix = infixExpression;
		postfix = "";
		this.operands = operands;
		convertToPostfix();
		evaluate();
	}

	private void evaluate() {
		/**
		 * ab*cd--
		 * 
		 * abc*-
		 * 
		 */
		ReferenceStack numOperands = new ReferenceStack();
		int operandCount = 0;
		for(int i = 0; i < postfix.length(); i++) {
			Character c = postfix.charAt(i);
			if(!Character.isLetter(c)) {
				double val2 = (Double)numOperands.pop();
				double val1 = (Double)numOperands.pop();
				numOperands.push(evaluate(val1, val2, c));
			}
			else {
				operandCount++;
				numOperands.push(operands[operandCount - 1]);
			}
		}
		result = (Double)numOperands.pop();
		System.out.println(numOperands);
	}
	private double evaluate(double val1, double val2, char c) {
		switch(c) {
		case '+': return val1 + val2;
		case '-': return val1 - val2;
		case '/': return val1 / val2; 
		case '*': return val1 * val2; 
		case '%': return val1 % val2; 
		}
		return -1;
	}

	private void convertToPostfix() {
		/**
		 * 
		 * a+c/b
		 * 
		 * acb/+ -- Ok to do divide, completely and add
		 * 
		 * a/c+b -- Incorrect
		 * acb+/ -- Correct Coz we complete last part then, move to the next so...
		 * 
		 * 
		 * (a+b)/(b/e+f)
		 * 
		 * if operator, or parenthesis, push to stack, else append to the end
		 * 
		 * Operator if is lesser precedence than previous one, then pop
		 * 
		 * b / e + f be/f+
		 * 
		 * If closing parenthesis, pop upto opening parenthesis
		 * 
		 * 
		 */
		ReferenceStack operator = new ReferenceStack();
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				//If digit/variable
				postfix += c;
			} else {
				if(operator.isEmpty()) {

					operator.push(c);
				}
				else if (c == ')') {
					while (((Character) operator.peek()) != '(') {
						postfix += ((Character)operator.pop());
					}
					operator.pop(); //remove open parenthesis
				}
				// When it is operator,
				else {
					//f/a+b*c-d-e
					// fa/abc*+de--
					while (!operator.isEmpty() && 
						 (char)operator.peek() != '(' && 
								 isLesserOrEqualToPrecedence(c, (Character) operator.peek())) {
						postfix += ((Character)operator.pop());
					}
					operator.push(c);
				}
			}
		}
		while (!operator.isEmpty()) {
			postfix += ((Character)operator.pop());
		}
	}


	private boolean isLesserOrEqualToPrecedence(char a, char b) {
		String smaller = "+-";
		String bigger = "*/%";
		if(a == b)
			return true;
		for (int i = 0; i < smaller.length(); i++) {
			for (int j = 0; j < bigger.length(); j++) {
				if (a == smaller.charAt(i) && b == bigger.charAt(j))
					return true;
			}
		}
		return false;
	}

	public String toString() {
		return infix + " : " + postfix + " = " + result;
	}
}
