import java.util.ArrayList;
import java.util.Scanner;

public class B1427 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int k = in.nextInt();
			ArrayList<Integer> arr = new ArrayList<Integer>();
			String s = in.next();
			int last = -1;
			for (int i = 0; i < n; i++) {
				if (s.charAt(i) == 'W') {
					arr.add(i-last-1);
				} else {
					
				}
			}
		}
	}
}
