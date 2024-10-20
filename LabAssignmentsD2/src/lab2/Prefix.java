package lab2;

public class Prefix {
	Prefix(String prefix){
		this.prefix = new StringBuffer(prefix);
	}
	StringBuffer prefix;
	/**
	 * This method modifies prefix value at the end
	 * @param p
	 * @return
	 */
	private StringBuffer convertPrefixToPostfix(StringBuffer p) {
		char ch = prefix.charAt(0);
		//Actually remove the character from the prefix
		prefix.deleteCharAt(0);
		if(Character.isLowerCase(ch)) {
			//Must convert ch to String and then to StringBuffer
			return new StringBuffer(String.valueOf(ch));
		}
		else {
			StringBuffer postfix1 = convertPrefixToPostfix(prefix);
			//At this point, mutable property of Stringbuffer prefix lets us extract next postfix
			StringBuffer postfix2 = convertPrefixToPostfix(prefix);
			return new StringBuffer(postfix1.toString() + postfix2.toString() + ch);
		}
	}
	
	String getPostfix() {
		String backup = prefix.toString();
		//Note, we might lose prefix property while converting to postfix
		String postfix = convertPrefixToPostfix(prefix).toString();
		prefix.insert(0, backup);
		return postfix;
	}
	

	boolean isValid() {
		int len = endPre(0, prefix.length() - 1);
		if(len >= 0 && len == prefix.length() - 1) {
			return true;
		}
		return false;
	}
	//Return position of end identifier
	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 * 
	 * First, finds first prefix expression end, 
	 * Then finds, next prefix expression end - - and return it
	 * 
	 * 
	 */
	int endPre(int start, int end) {
		if(start < 0 || start > end) {
			return -1;
		}
		else {
			char ch = prefix.charAt(start);
			//When character is identifier
			if(Character.isLowerCase(ch)) {
				//Return the index
				return start;
			}
			else if(isOperator(ch)){
				int firstEnd = endPre(start + 1, end);
				if(firstEnd > -1) {
					int secondEnd = endPre(firstEnd + 1, end);
					return secondEnd;
				}
				else
					return -1;
			}
			else {
				return -1;
			}
		}
	}

	private boolean isOperator(char ch) {
		switch(ch) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '%':
			return true;
		default: return false;
		}
	}
}
