import java.util.Scanner;

public class B1380 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			String s = in.next();
			int rock = 0;
			int paper = 0;
			int scissors = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'R') {
					rock++;
				} else if (s.charAt(i) == 'P') {
					paper++;
				} else {
					scissors++;
				}
			}
			if (rock >= scissors && rock >= paper) {
				for (int i = 0; i < s.length(); i++)
					System.out.print("P");
			} else if (scissors >= rock && scissors >= paper) {
				for (int i = 0; i < s.length(); i++)
					System.out.print("R");
			} else {
				for (int i = 0; i < s.length(); i++)
					System.out.print("S");
			}
			System.out.println();
		}
	}
}
