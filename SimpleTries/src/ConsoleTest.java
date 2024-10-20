import java.io.Console;

public class ConsoleTest {

	public static void main(String[] args) {
		Console c = System.console();
		if (c == null) {
			System.err.println("No console available.");
			System.exit(1);
			} // end
		String password = String.valueOf(c.readPassword());
		System.out.println("Tada! I know you password which is " + password);
	}

}
