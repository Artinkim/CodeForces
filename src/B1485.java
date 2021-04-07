import java.util.Scanner;

public class B1485 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		for (int i = 1; i < n-1; i++) {
			dp[i] = dp[i - 1] + ((arr[i]-arr[i-1]-1)+(arr[i+1]-arr[i]-1));
		}
		for (int i = 0; i < q; i++) {
			int l = in.nextInt() - 1;
			int r = in.nextInt() - 1;
			if(l == r) {
				System.out.println(k-1);
			} else {
				System.out.println((arr[l] - 1) +(arr[l+1]-arr[l]-1)+ (dp[r-1] - dp[l])+(arr[r]-arr[r-1]-1) + k - arr[r]);
			}
		}
	}
}
