import java.util.ArrayList;
import java.util.Scanner;

public class C1370 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			if (n == 1) {
				System.out.println("FastestFinger");
				continue;
			}
			if (n == 2) {
				System.out.println("Ashishgup");
				continue;
			}
			if (n % 2 == 1) {
				System.out.println("Ashishgup");
				continue;
			}
			ArrayList<Integer> arr = new ArrayList<Integer>();
			int x = (int) Math.sqrt(n);
			for (int i = 2; i < x; i++) {
				while (n % i == 0) {
					arr.add(i);
					n /= i;
				}
			}
			if (n > 1)
				arr.add(n);
			boolean ans = false;
			int evenCount = 0;
			int oddCount = 0;
			for (int i = 0; i < arr.size(); i++) {
				// System.out.println(arr.get(i));
				if (arr.get(i) % 2 == 1) {
					oddCount++;
				} else {
					evenCount++;
				}
			}
			if (oddCount == 0) {
				System.out.println("FastestFinger");
			} else {
				if (evenCount == 1) {
					if (oddCount == 1) {
						System.out.println("FastestFinger");
					} else {
						System.out.println("Ashishgup");
					}
				} else {
					System.out.println("Ashishgup");
				}
			}
//			if (ans) {
//				if (count == 1) {
//					System.out.println("FastestFinger");
//				} else {
//					System.out.println("Ashishgup");
//				}
//			} else {
//				if (count == 1) {
//					System.out.println("Ashishgup");
//				} else {
//					System.out.println("FastestFinger");
//				}
//			}
		}
	}
}
