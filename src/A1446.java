import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class A1446 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			long w = in.nextLong();
			ArrayList<Integer> arr = new ArrayList<Integer>();
			// System.out.println(n+" "+w);
			int ans = -1;
			int[] arr1 = new int[n];
			int i = 0;
			for (; i < n; i++) {
				arr1[i] = in.nextInt();

				if (arr1[i] > w) {

				} else if (arr1[i] > w / 2) {
					ans = i;
					break;
				} else {
					arr.add(i);
				}
			}

			if (ans != -1) {
				System.out.println(1);
				System.out.println(i + 1);
			} else if (arr.size() < 2) {
				System.out.println(-1);
			} else {
				long sum = 0;
				int k = 0;
				while (k < arr.size() && sum < w / 2) {
					sum += arr1[arr.get(k)];
					k++;
				}
				if (sum < w / 2) {
					System.out.println(-1);
				} else {
					System.out.println(i);
					for (int j = 0; j < k; j++) {
						System.out.print((arr.get(j) + 1) + " ");
					}
					System.out.println();
				}
			}

		}
	}
}
