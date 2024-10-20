package expressions;

public class TestExpression {

	public static void main(String[] args) {
		// abc*d-+
		// a +(b*c-d)
		Expression e1 = new Expression("a+(b*c-d)/(e+f)", new double[] {2, 3, 9, 10, 3, 2});
		System.out.println(e1);

	}

}
