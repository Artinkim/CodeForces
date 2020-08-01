import java.util.Scanner;

public class E1365 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, Long.parseLong(in.next()));
		}
		int x = Long.toBinaryString(max).length();
		long sum = 0;
		for(int i = 0;i<x;i++) {
			sum+=Math.pow(2, i);
		}
		System.out.println(sum);
	}
}
