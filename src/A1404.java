import java.util.Scanner;
 
public class A1404 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int k = in.nextInt();
			String s = in.next();
//		int n = 4;
//		int k = 2;
//		String s = "1??1";
			int count0 = 0;
			int count1 = 0;
			int count = 0;
			for (int i = 0; i < k; i++) {
				if (s.charAt(i) == '0') {
					count0++;
				} else if (s.charAt(i) == '1') {
					count1++;
				} else {
					count++;
				}
			}
			if (Math.abs(count0 - count1) > count) {
				System.out.println("NO");
				continue;
			}
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				if (s.charAt(i) == '0') {
					arr[i] = 0;
				} else if (s.charAt(i) == '1') {
					arr[i] = 1;
				} else {
					arr[i] = 2;
				}
			}
			int zeros = (k / 2) - count0;
			int ones = (k / 2) - count1;
			//System.out.println(count0+" "+count1);
			//System.out.println(zeros+" "+ones);
			boolean passed = true;
			for (int i = k; i < n; i++) {
				if (arr[i] == 0) {
					if (arr[i-k] == 1) {
						passed = false;
					} else if (arr[i-k] == 2) {
						if (zeros == 0) {
							passed = false;
						}
						zeros--;
					}
				} else if (arr[i] == 1) {
					if (arr[i-k] == 0) {
						passed = false;
					} else if (arr[i-k] == 2) {
						if (ones == 0) {
							passed = false;
						}
						ones--;
					}
				} else {
					arr[i] = arr[i-k];
				}
			}
			//System.out.println(s);
			if (passed) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}