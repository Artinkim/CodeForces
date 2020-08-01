import java.util.ArrayList;
import java.util.Scanner;

public class D1367 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		int[] count;
		while (q-- > 0) {
			count = new int[26];
			String str = in.next();
			for (int i = 0; i < str.length(); i++) {
				count[str.charAt(i) - 'a']++;
			}
			int m = in.nextInt();
			boolean[] visited = new boolean[m];
			int[] arr = new int[m];
			for (int i = 0; i < m; i++) {
				arr[i] = in.nextInt();
			}
			ArrayList<Integer> list = new ArrayList<Integer>();
			int k = 25;
			boolean check = true;
			char[] ans = new char[m];
			while (check) {
				check = false;
				for (int i = 0; i < m; i++) {
					if (visited[i])
						continue;
					check = true;
					if (arr[i] == 0) {
						list.add(i);
						visited[i] = true;
					}
				}
				if (!check)
					break;
				while (count[k] < list.size() && k > 0)
					k--;
				for (int i = 0; i < list.size(); i++) {
					ans[list.get(i)] = ((char) (k + 97));
				}
				k--;
				for (int i = 0; i < m; i++) {
					if (visited[i])
						continue;
					for (int j = 0; j < list.size(); j++) {
						arr[i] -= Math.abs(i - list.get(j));
					}
				}
				list.clear();
			}
			System.out.println(new String(ans));
		}
	}
}
