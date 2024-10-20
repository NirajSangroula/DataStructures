package assignment4.e1;

public class Calculator {
	String infix;
	String postfix;
	public Calculator(String infixExpression) throws IllegalStateException{
		this.infix = infixExpression;
		postfix = "";
		if(!convertPostfix())
			throw new IllegalStateException("expression invalid");
	}

	public int evaluate() throws IllegalStateException{
		if(postfix == "")
			throw new IllegalStateException("Infix is not converted to postfix yet");
		ReferenceStack<Integer> numOperands = new ReferenceStack<Integer>();
		for(int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			if(!Character.isDigit(c)) {
				int val2 = numOperands.pop();
				int val1 = numOperands.pop();
				numOperands.push(operate(val1, val2, c));
			}
			else {
				numOperands.push(Integer.parseInt(String.valueOf(c)));
			}
		}
		return numOperands.pop();
	}
	private int operate(int val1, int val2, char c) throws IllegalStateException {
		switch(c) {
		case '+': return val1 + val2;
		case '-': return val1 - val2;
		case '/': return val1 / val2; 
		case '*': return val1 * val2; 
		case '%': return val1 % val2; 
		}
		throw new IllegalStateException("Operation invalid");
	}

	private boolean convertPostfix() {
		ReferenceStack<Character> operator = new ReferenceStack<Character>();
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if (Character.isDigit(c)) {
				//If digit, simply append to the end
				postfix += c;
			} 
			//Otherwise it must be an operator
			else {
				//If not any operators exist yet, push current to stack
				if(operator.isEmpty()) {
					operator.push(c);
				}
				//If it is closing parenthesis, pop until we get (
				else if (c == ')') {
					while (((Character) operator.peek()) != '(') {
						postfix += ((Character)operator.pop());
					}
					operator.pop(); //remove open parenthesis
				}
				// When it is ordinary operator operator,
				else {
					//Return false if operator is invalid
					if(!(c == '+' || c == '-' || c == '/' || c == '*' || c == '%' || c == '(' || c == ')'))
						return false;
					while (!operator.isEmpty() && 
						 (char)operator.peek() != '(' && 
							isLesserOrEqualToPrecedence(c, operator.peek())) {
						postfix += (operator.pop());
					}
					operator.push(c);
				}
			}
		}
		while (!operator.isEmpty()) {
			postfix += (operator.pop());
		}
		return true;
	}
	
	public String getPostFix() throws IllegalStateException{
		if(postfix != "")
			return postfix;
		throw new IllegalStateException("Postfix not converted yet");
	}

	private boolean isLesserOrEqualToPrecedence(char a, char b) {
		if(getPriority(a) - getPriority(b) >= 0)
			return true;
		else
			return false;
		
	}

	private int getPriority(char a) {
		switch (a) {
		case '+' : return 10;
		case '-' : return 5;
		case '*':case '/': case '%' : return 20;
		default: return 0;
		}
	}

	public String toString() {
		return infix + " : " + getPostFix() + " = " + evaluate();
	}
}
