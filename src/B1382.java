import java.util.Scanner;

public class B1382 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			if (n == 1) {
				System.out.println("First");
				in.nextLine();
				in.nextLine();
				continue;
			}
			int i = 0;
			for (; i < n - 1; i++) {
				//String x = in.next();
				//System.out.print(x+" ");
				if (in.nextInt() != 1)
					break;
			}
			in.nextLine();
			//System.out.println(i+" N:"+n);
			if (i % 2 == 1) {
				System.out.println("Second");
			} else {
				System.out.println("First");
			}
		}
	}
}
