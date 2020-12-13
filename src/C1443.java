import java.util.Arrays;
import java.util.Scanner;

public class C1443 {
	public static void main(String[] args) { //Pretty much solved,but for some reason TLE. Even though O(N) 
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int[] arr1 = new int[n];
			for (int i = 0; i < n; i++) {
				arr1[i] = in.nextInt();
			}
			//int[] arr2 = new int[n];
			Pair5[] pairs = new Pair5[n];
			// pairs[n] = new Pair5(0,0)
			for (int i = 0; i < n; i++) {
				pairs[i] = new Pair5(arr1[i], in.nextInt());
			}
			Arrays.sort(pairs);
			int sum = 0;
			int i = n - 1;
			while (i > -1 && sum + pairs[i].y < pairs[i].x) {
				sum += pairs[i].y;
				i--;
			}
			if(i<0) {
				System.out.println(sum);
			} else {
				System.out.println(Math.max(pairs[i].x,sum));
			}
			//System.out.println(Math.max(sum,pairs[Math.max(i,0)].x));
		}
	}
}

class Pair5 implements Comparable<Pair5> {
	int x;
	int y;

	Pair5(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pair5 o) {
		// TODO Auto-generated method stub
		return this.x - o.x;
	}
}