import java.util.ArrayList;
import java.util.Scanner;

public class C1494 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			ArrayList<Integer> arr1 = new ArrayList<Integer>();
			ArrayList<Integer> arr2 = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				int temp = in.nextInt();
				if (t < 0) {
					arr1.add(temp * -1);
				} else {
					arr2.add(temp);
				}
				
			}

		}
	}
}
