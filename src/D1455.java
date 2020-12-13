import java.util.ArrayList;
import java.util.Scanner;

public class D1455 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int x = in.nextInt();
			ArrayList<Integer>[] arr = new ArrayList[501];
			for (int i = 0; i < 501; i++) {
				arr[i] = new ArrayList<Integer>();
			}
			int[] arr2 = new int[n];
			for (int i = 0; i < n; i++) {
				int temp = in.nextInt();
				arr2[i] = temp;
				arr[temp].add(i);
			}
			int largestNumCount = 1;
			int valueOfLast = 0;
			if (n > 1) {
				boolean wait = false;
				for (int i = 500; i >= 0; i--) {
					if (arr[i].size() != 0) {
						largestNumCount = arr[i].size();
						valueOfLast = i;
						if (wait)
							break;
						wait = true;
					}
				}
			}
			// System.out.println(largestNumCount);
			int offset = 0;
			boolean pass = true;
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < arr[i].size(); j++) {
					if (!arr[i].contains(offset)) {
						pass = false;
						break;
					}
					offset++;
				}
				if (!pass)
					break;
			}
			// System.out.println(pass);
			int last = 0;
			if (pass) {
				int ans = 0;
				while (offset < n - largestNumCount - last && arr2[offset] > x) {
					// System.out.println(offset + " " + x);'
					if (x == valueOfLast) {
						last = 1;
					} else {
						last = 0;
					}
					x = arr2[offset];
					offset += arr[arr2[offset]].size();

					ans++;
				}
				if (offset < n - largestNumCount) {
					System.out.println(-1);
				} else {
					System.out.println(ans);
				}
			} else {
				System.out.println(-1);
			}

//			int nextVal = -1;
//			for (int i = x + 1; i < n; i++) {
//				if (arr[i].size() != 0)
//					nextVal = i;
//			}
//			if (!arr[nextVal].contains(offset)) {
//				pass = false;
//			}
		}
	}
}
