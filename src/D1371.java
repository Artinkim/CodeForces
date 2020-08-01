import java.util.Scanner;

public class D1371 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[][] arr = new int[n][n];
			int ans = -1;
			if (k % n == 0) {
				ans = 0;
			} else {
				ans = 2;
			}
			System.out.println(ans);
			// int div = (int) Math.ceil((double) k / (double) n);
			int div = 0;
			char[] s;
			for (int j = 0; j < n; j++) {
//				if (k / (n - j - 1) < div)
//					div = k / (n - j - 1);
				div = (int) Math.ceil((double) k / (double) (n - j));
				k -= div;
				s = new char[n];
				for (int i = j; i < j + div; i++) {
					s[i % n] = '1';
				}
				for (int i = j + div; i < j + n; i++) {
					s[i % n] = '0';
				}
				System.out.println(new String(s));
			}
		}
	}
}
