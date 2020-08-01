import java.util.Arrays;
import java.util.Scanner;

public class C1369 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] arr1 = new int[n];
			for (int i = 0; i < n; i++) {
				arr1[i] = in.nextInt();

			}
			int[] arr2 = new int[k];
			Arrays.sort(arr1);
			long sum = 0;
			int i = 0;
			for (int w = 0; w < k; w++) {
				int tmp = in.nextInt();
				if (tmp == 1) {
					sum += arr1[n - 1 - i] * 2;
					i++;
				} else {
					arr2[w] = tmp - 1;
				}
			}

			Arrays.sort(arr2);
//			for (; i < k; i++) {
//				if (arr2[i] == 1) {
//					sum += arr1[j] * 2;
//					j--;
//				} else {
//					break;
//				}
//			}
			int tmp = n - 1 - k;
			int j = n - 1 - i;
			for (; j > tmp; j--) {
				sum += arr1[j];
			}
			j++;
			for (; i < k; i++) {
				j -= arr2[i];
				sum += arr1[j];
			}
			System.out.println(sum);
		}
	}
}
