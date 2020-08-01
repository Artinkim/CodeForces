import java.util.Arrays;
import java.util.Scanner;

public class C1380 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int x = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			Arrays.sort(arr);
			int ans = 0;
			int count = 0;
			for (int i = n - 1; i >= 0; i--) {
				if (arr[i] / x >= 1) {
					ans++;
				} else {
					count++;
					if (count == Math.ceil((double) x / (double) arr[i])) {
						ans++;
						count = 0;
					}
				}
			}
			System.out.println(ans);
		}
	}
}
