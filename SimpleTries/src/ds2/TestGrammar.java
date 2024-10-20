package ds2;

public class TestGrammar {
	boolean isPallindrome(String w) {
		if(w.length() == 0)
			return true;
		if(w.length() == 1)
			return true;
		else {
			if(w.charAt(0) == w.charAt(w.length() - 1)) {
				return isPallindrome(substringFirstLast(w));
			}
			else
				return false;
		}
	}
	
	boolean isIdentifier(String w){
		if(w.length() == 1) {
			if(Character.isLetter(w.charAt(0))) {
				return true;
			}
			else
				return false;
		}
		else {
			if(Character.isLetterOrDigit(w.charAt(w.length() - 1)))
					return isIdentifier(w.substring(0, w.length() - 1));
			else
				return false;
		}
	}
	
	boolean isAnBn(String w) {
		if(w.length() == 0)
			return true;
		else {
			if(w.charAt(0) == 'A' && w.charAt(w.length() - 1) == 'B') {
				return isAnBn(substringFirstLast(w));
			}
			else
				return false;
		}
	}

	private String substringFirstLast(String w) {
		if(w.length() < 3)
			return "";
		else
			return w.substring(1, w.length() - 1);
	}
}
