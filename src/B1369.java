import java.util.Scanner;

public class B1369 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			String s = in.next();
			int count = 0;
			boolean[] removed = new boolean[n];
			int last = s.lastIndexOf("0");
			int first = s.indexOf("1");
			for (int i = 0; i < n; i++) {
				if (s.charAt(i) == '1') {
					count++;
				} else {
					if (count == 1) {
						if (i == last) {
							removed[first] = true;
						} else {
							removed[i] = true;
						}
					} else if (count > 1) {
						if (i == last) {
							for (int j = i - 1; count > 1; j--) {
								count--;
								removed[j] = true;
							}
							removed[first] = true;
						} else {
							count++;
							for (int j = i; count > 1; j--) {
								count--;
								removed[j] = true;
							}
						}

					}
				}
			}
			String ans = "";
			for (int i = 0; i < n; i++) {
				if (!removed[i])
					ans += s.charAt(i) + "";
			}
			System.out.println(ans);
		}
	}
}
