import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class E1506 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}

			System.out.print(arr[0] + " ");
			int last = arr[0];
			int lowest = 1;
			boolean[] used = new boolean[n + 1];
			used[arr[0]] = true;
			for (int i = 1; i < n; i++) {
				if (last == arr[i]) {
					while (used[lowest]) {
						lowest++;
					}
					System.out.print(lowest + " ");
					lowest++;
				} else {
					System.out.print(arr[i] + " ");
					used[arr[i]] = true;
					last = arr[i];
				}
			}
			System.out.println();
			System.out.print(arr[0] + " ");
			Stack<Integer> stack = new Stack<Integer>();
			last = arr[0];
			for (int i = 1; i < arr[0]; i++) {
				stack.push(i);
			}
			for (int i = 1; i < n; i++) {
				if (last == arr[i]) {
					System.out.print(stack.pop() + " ");
				} else {
					System.out.print(arr[i] + " ");
					for (int j = last + 1; j < arr[i]; j++) {
						stack.push(j);
					}
					last = arr[i];
				}
			}
		}
	}
}
