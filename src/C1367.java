import java.util.Scanner;

public class C1367 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int k = in.nextInt();
			String s = in.next();
			int tmp = -(k + 1);
			if (s.charAt(0) == '1')
				tmp = 0;
			int ans = 0;
			for (int i = 0; i < n; i++) {
				if (s.charAt(i) == '1') {
					ans += Math.max(0, (i - tmp - k - 1) / (k + 1));
					tmp = i;
				}
			}
			ans += (n - 1 - tmp) / (k + 1);
			System.out.println(ans);
		}
	}
}
