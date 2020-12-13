import java.util.Arrays;
import java.util.Scanner;

public class D2_1419 {
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		long[] arr = new long[n];
//		for (int i = 0; i < n; i++) {
//			arr[i] = in.nextInt();
//		}
		int n = 6;
		long[] arr = { 1, 3, 2, 2, 4, 5};

		Arrays.sort(arr);
		long[] arr2 = new long[n];
		int j = 0;
		for (int i = n - 1; i > (n / 2) - 1; i--) {
			arr2[j] = arr[i];
			j += 2;
		}
		j = 1;
		for (int i = (n / 2) - 1; i >= 0; i--) {
			arr2[j] = arr[i];
			j += 2;
		}
//		for (long i = 0; i < n / 2; i++) {
//			arr2[j] = arr[n - 1 - i];
//			arr2[j + 1] = arr[n / 2 - i];
//			// System.out.prlong(arr[n - 1 - i] + " " + arr[n / 2 - i] + " ");
//
//		}
//		if (n % 2 == 1)
//			arr2[n - 1] = arr[n / 2 + 1];
		int ans = 0;
		for (int i = 0; i < n - 2; i++) {
			if (arr2[i] > arr2[i + 1] && arr2[i + 2] > arr2[i + 1])
				ans++;
		}
		System.out.println(ans);
		for (int i = 0; i < n; i++) {
			System.out.print(arr2[i] + " ");
		}
	}

}
