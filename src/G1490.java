import java.util.ArrayList;
import java.util.Scanner;

public class G1490 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			ArrayList<Integer> arr = new ArrayList<Integer>(n + 1);
			ArrayList<Integer> indicies = new ArrayList<Integer>(n + 1);
			int temp = in.nextInt();
			for (int i = 1; i < n; i++) {
				if()
				arr[i] = in.nextInt() + arr[i - 1];
			}
			for (int i = 0; i < m; i++) {
				int x = in.nextInt();
				int times = (int) Math.ceil(x / (double) arr[n - 1]);

				int min = Integer.MAX_VALUE;
				int ans = -1;
				for (int j = 0; j < n; j++) {
					if (arr[j] >= x) {
						ans = j;
						break;
					} else if (arr[n - 1] > 0) {
						int spins = (int) Math.ceil((x - arr[j]) / (double) arr[n - 1]);
						if (spins < min) {
							min = spins;
							ans = n * spins + j;
						}
					}
				}
				System.out.print(ans + " ");
			}
			System.out.println();
		}
	}

}
