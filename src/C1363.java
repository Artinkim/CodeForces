import java.util.Scanner;

public class C1363 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int x = in.nextInt()-1;
			int[] arr = new int[n];
			for (int j = 0; j < n-1; j++) {
				arr[(in.nextInt() - 1)]++;
				arr[(in.nextInt() - 1)]++;
			}
			if (arr[x] < 2) {
				System.out.println("Ayush");
			} else {
				if (n % 2 == 0) {
					System.out.println("Ayush");
				} else {
					System.out.println("Ashish");
				}
			}
		}
	}
}
