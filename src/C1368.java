import java.util.Scanner;

public class C1368 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] diff = { { 1, 2, 2, 2, 1, 0, 0 }, { 0, 0, 1, 2, 2, 2, 1 }, {-1, -2, -2, -2, -1, 0, 0 },
				{0, 0, -1, -2, -2, -2, -1 } };
		System.out.println((15 + 7 * (n - 1)));
		System.out.println(0+" "+0);
		for (int j = 0; j < 7; j++) {
			System.out.println(diff[2][j] + " " + diff[3][j]);
		}
		for (int j = 0; j < 7; j++) {
			System.out.println(diff[0][j] + " " + diff[1][j]);
		}
		boolean b = true;
		for (int i = 1; i < n; i++) {
			if (b) {
				for (int j = 0; j < 7; j++)
					System.out.println(diff[2][j] + " " + (i * 2 + diff[1][j]));
			} else {
				for (int j = 0; j < 7; j++)
					System.out.println(diff[0][j] + " " + (i * 2 + diff[1][j]));
			}
			b = !b;
		}
	}
}
