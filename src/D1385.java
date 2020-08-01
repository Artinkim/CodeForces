import java.util.Scanner;

public class D1385 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			String str = in.next();
			if (str.length() == 1) {
				if (str.equals("a")) {
					System.out.println("0");
				} else {
					System.out.println("1");
				}
				continue;
			}
			System.out.println(recurse(str, 'a') + "");
//			if (str.length() == 2) {
//				if (str.charAt(0) == str.charAt(1) - 1 || str.charAt(0) == str.charAt(1) + 1) {
//					System.out.println("0");
//				} else {
//					System.out.println("1");
//				}
//				continue;
//			}

//			for (int i = 0; i < n; i++) {
//				// System.out.println((char) (i + 97));
//				if (str.indexOf((char) (i + 97)) != -1) {
//					System.out.println(recurse(str, (char) (i + 97)) + "");
//					break;
//				}
//			}

//			int[][] dpf = new int[str.length() + 1][26];
//			int[][] dpb = new int[str.length() + 1][26];
//			for (int i = 1; i < str.length(); i++) {
//				dpf[i] = dpf[i - 1];
//				dpf[i][str.charAt(i) - 61]++;
//				dpb[n - i] = dpf[n - i + 1];
//				dpb[n - i][str.charAt(n - i) - 61]++;
//			}
//			int min = 0;
//			int max = str.length();
//			int ans = 0;
//			int index = -1;
//			int dist = (int) Math.ceil(Math.log(str.length()) / Math.log(2));
//			while (min != max) {
//				index = min / max;
//				for (int i = 0; i < 26 - dist; i++) {
//					if (dpf[index][i] > dpb[index][i]) {
//
//					} else if (dpf[index][i] < dpb[index][i]) {
//
//					}
//				}
//			}

		}
	}

	static int recurse(String str, char c) {
		if (str.length() == 1) {
			return str.charAt(0) != c ? 1 : 0;
		}
		String l = str.substring(0, str.length() / 2);
		String r = str.substring((int) Math.ceil(str.length() / 2), str.length());
		int lcnt = (str.length() / 2) - (l.length() - l.replace(c + "", "").length()) + recurse(r, (char) (c + 1));
		int rcnt = (str.length() / 2) - (r.length() - r.replace(c + "", "").length()) + recurse(l, (char) (c + 1));
		return Math.min(lcnt, rcnt);
	}
}
