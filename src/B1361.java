import java.util.Arrays;
import java.util.Scanner;

public class B1361 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] dp = new int[20];
		while (t-- > 0) {
			int n = in.nextInt();
			int p = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			Arrays.sort(arr);
			for (int i = n-1; i >= 0; i--) {
				
			}
		}
	}
}
