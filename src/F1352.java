import java.util.Scanner;

public class F1352 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int zeroes = in.nextInt();
			int ones = in.nextInt();
			int twos = in.nextInt();
			StringBuilder sb = new StringBuilder();
			if (zeroes == 0) {
				if (twos == 0) {
					for (int i = 0; i < ones + 1; i++) {
						sb.append(i % 2 + "");
					}
				} else {
					if (ones == 0) {
						for (int i = 0; i < twos + 1; i++) {
							sb.append("1");
						}
					} else {
						int start = (ones + 1) % 2;
						for (int i = start; i < ones + 1 + start; i++) {
							sb.append(i % 2 + "");
						}
						for (int i = 0; i < twos; i++) {
							sb.append("1");
						}
					}
				}
			} else {
				if (twos == 0) {
					int start = ones % 2;
					for (int i = start; i < ones + start; i++) {
						sb.append(i % 2 + "");
					}
					for (int i = 0; i < zeroes + 1; i++) {
						sb.append("0");
					}
				} else {
					int start = (ones - 1) % 2;
					for (int i = start; i < ones - 1 + start; i++) {
						sb.append(i % 2 + "");
					}
					for (int i = 0; i < zeroes + 1; i++) {
						sb.append("0");
					}
					for (int i = 0; i < twos + 1; i++) {
						sb.append("1");
					}
				}
			}
			System.out.println(sb.toString());
		}
	}
}
