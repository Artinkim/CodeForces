import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class A1446Better {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			long w = in.nextLong();
			Int[] arr = new Int[n];
			HashMap<Int, Integer> map = new HashMap<Int, Integer>();
			for (int i = 0; i < n; i++) {
				arr[i] = new Int(in.nextInt());
				// System.out.print(arr[i] + " ");
				map.put(arr[i], i);
			}

			Arrays.sort(arr);
			// System.out.println(arr[n - 1] + " " + w);
			int j = n - 1;
			while (j >= 0 && arr[j].x > w) {
				j--;
			}
			if (j == -1) {
				System.out.println(-1);
			} else if (arr[j].x >= (w + 1) / 2) {
				System.out.println(1);
				System.out.println(map.get(arr[j]) + 1);
			} else {
				long sum = 0;
				int ans = -1;
				for (int i = j; i >= 0; i--) {
					sum += arr[i].x;
					if (sum >= (w + 1) / 2) {
						ans = j - i + 1;
						break;
					}
				}
				System.out.println(ans);
				if (ans != -1) {
					for (int i = j; i >= j - ans + 1; i--) {
						System.out.print((map.get(arr[i]) + 1) + " ");
					}
				}
			}
		}
	}
}

class Int implements Comparable<Int> {
	int x;

	Int(int x) {
		this.x = x;
	}

	@Override
	public int compareTo(Int o) {
		// TODO Auto-generated method stub
		return this.x - o.x;
	}
}
