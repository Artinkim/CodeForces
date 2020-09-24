import java.util.HashMap;
import java.util.Scanner;

public class C1398 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			String str = in.next();
			long ans = 0;
			HashMap<Long, Long> map = new HashMap<Long, Long>();
			map.put((long) 0, (long) 1);
			long tmp = 0;
			for (int i = 0; i < n; i++) {
				tmp += Integer.parseInt("" + str.charAt(i));
				long x = (int) (tmp - i - 1);
				if (!map.containsKey(x)) {
					map.put(x, (long) 0);
				}
				map.put(x, map.get(x) + 1);
				ans += map.get(x) - 1;
			}
			System.out.println(ans);
		}
	}
}
