import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class F1490 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < n; i++) {
				int temp = in.nextInt();
				if (map.get(temp) == null) {
					map.put(temp, 1);
				} else {
					map.put(temp, map.get(temp) + 1);
				}
			}
			Collection values = map.values();
			int[] arr = new int[n];
			int j = 0;
			for (int x : map.values()) {
				arr[j] = x;
				j++;
			}
			Arrays.sort(arr);
			int[] dp = new int[n];
			dp[0] = arr[0];
			for (int i = 1; i < n; i++) {
				dp[i] = arr[i] + dp[i - 1];
			}
			int i = 0;
			int last = 0;
			int ans = Integer.MAX_VALUE;
			while (i < n) {
				i++;
				while (i < n && arr[i] == arr[last]) {
					i++;
				}
				int removalsGreater = (dp[n - 1] - dp[i - 1]) - ((n - i) * arr[i - 1]);
				int removalsLess = (last - 1) < 0 ? 0 : dp[last - 1];
				ans = Math.min(ans, removalsGreater + removalsLess);
				last = i;
			}
			System.out.println(ans);
		}
	}
}
