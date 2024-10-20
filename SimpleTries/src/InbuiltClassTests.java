import java.util.StringTokenizer;

public class InbuiltClassTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringTokenizer st = new StringTokenizer("Malai-maaf-garideu mera lovi najar-kai kashai maa dube chha vane-ma ta khoji rahechhu", "-");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}

	}

}
