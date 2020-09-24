import java.util.Scanner;

public class D1409 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			String n = in.next();
			n = "0" + n;
			char[] ar = n.toCharArray();
			int[] arr = new int[n.length()];
			int s = in.nextInt();
			int sum = 0;
			for (int i = 0; i < n.length(); i++) {
				arr[i] = Integer.parseInt(ar[i] + "");
				sum += arr[i];
			}
			int index = 0;
			long ans = 0;
			while (sum > s) {
				int ind = n.length() - index - 1;
				int current = arr[ind];
				ans += (10 - current) * (long) Math.pow(10, index);
				do {
					arr[ind] = 0;
					ind--;
					current = arr[ind];
				} while (current == 9);
				arr[ind]++;
				sum = 0;
				for (int i = 0; i < n.length(); i++) {
					sum += arr[i];
				}
				index++;
			}
			System.out.println(ans);
		}
	}
}
