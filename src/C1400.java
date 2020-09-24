import java.util.Arrays;
import java.util.Scanner;

public class C1400 {
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int t = in.nextInt();
//		while (t-- > 0) {
		String s = "101110";
		int x = 2;
		boolean works = true;
		int[] arr = new int[s.length()];
		int[] ans = new int[s.length()];
		Arrays.fill(arr, -1);
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i) - 48;
		}
		for (int i = x; i < s.length(); i += x) {
			arr[i] = arr[i+x];
			if (ans[i-x] == 0) {
				if (arr[i - x] != 0) {
					works = false;
					break;
				}
				arr[i+x] = 0;
 			} else {
				if (arr[i - x] == 0) {
					works = false;
					break;
				}
			}
		}
		
		for (int i = 0; i < s.length(); i++) {
			System.out.println(arr[i]);
//				if (arr[i] == 2) {
//					works = false;
//					break;
//				}
			//ans += arr[i] + "";
		}
		if (works) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}
		
	}
}
