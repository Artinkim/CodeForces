import java.util.Arrays;
import java.util.Scanner;

public class G1506Better {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			String s = in.next();
			int[] lastOccurance = new int[26];
			Arrays.fill(lastOccurance, -1);
			for (int i = s.length() - 1; i >= 0; i--) {
				if (lastOccurance[s.charAt(i) - 97] == -1) {
					lastOccurance[s.charAt(i) - 97] = i;
				}
			}
			StringBuilder sb = new StringBuilder();
			boolean[] used = new boolean[26];
			sb.append(s.charAt(0));
			used[s.charAt(0) - 97] = true;

			for (int i = 1; i < s.length(); i++) {
				if (used[s.charAt(i) - 97]) {
					continue;
				}
				while ((sb.length() - 1 >= 0) && (s.charAt(i) > sb.charAt(sb.length() - 1))
						&& (lastOccurance[sb.charAt(sb.length() - 1) - 97] > i)) {

					used[sb.charAt(sb.length() - 1) - 97] = false;
					sb.deleteCharAt(sb.length() - 1);
				}
				sb.append(s.charAt(i));
				used[s.charAt(i) - 97] = true;
			}
			System.out.println(sb.toString());
		}
	}
}
