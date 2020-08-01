import java.util.Arrays;
import java.util.Scanner;

public class C1364 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n + 2];
		int[] ans = new int[n + 2];
		Arrays.fill(ans, -1);
		arr[n+1] = -1;
		boolean[] exclude = new boolean[100005];
		for (int i = 1; i < n + 1; i++)
			arr[i] = in.nextInt();
		for (int i = 2; i < n + 2; i++) {
			if (arr[i] != arr[i - 1]) {
				ans[i] = arr[i - 1];
				exclude[ans[i]] = true;
			}
		}
		int j = 0;
		for (int i = 1; i <= n; i++) {
			while (exclude[j])
				j++;
			if (ans[i] == -1) {
				ans[i] = j;
				exclude[j] = true;
			}
			System.out.print(ans[i]+" ");
		}
	}
}
