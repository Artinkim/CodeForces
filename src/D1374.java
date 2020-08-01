import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class D1374 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] arr = new int[n];
			TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
			// HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			boolean[] visited = new boolean[n];
			int count = n;
			for (int i = 0; i < n; i++) {
				int temp = k - in.nextInt() % k;
				if (temp == k) {
					count--;
					continue;
				}
				if (tm.containsKey(temp)) {
					tm.put(temp, tm.get(temp) + 1);
				} else {
					tm.put(temp, 1);
				}
				// System.out.print(arr[i] + " ");
			}
			boolean b = true;
			long ans = 0;
			while (b) {
				int x = 0;
				int last = 0;
				for (Entry<Integer, Integer> entry : tm.entrySet()) {
					if (entry.getValue() == 0)
						continue;
					if (last == entry.getKey())
						continue;
					// System.out.println(arr[i] + " " + x + " " + ans + " ");
					last = entry.getKey();
					count--;
					ans += entry.getKey() - x + 1;
					x = entry.getKey() + 1;
					tm.put(entry.getKey(), entry.getValue() - 1);
				}
				if (count == 0)
					break;
				if (x != 0)
					ans += k - x;
			}
			System.out.println(ans);
		}
	}
}
