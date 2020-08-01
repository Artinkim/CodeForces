import java.util.Arrays;
import java.util.Scanner;

public class E1_1374Better {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		Triple2[] arr = new Triple2[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Triple2(in.nextInt(), (in.nextInt() == 1), (in.nextInt() == 1));
		}
		Arrays.sort(arr);
	}
}

class Triple2 implements Comparable<Triple2> {
	int x;
	boolean y;
	boolean z;

	Triple2(int x, boolean y, boolean z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public int compareTo(Triple2 o) {
		// TODO Auto-generated method stub
		if (this.x == o.x) {
			return (y ? 1 : 0) - (o.y ? 1 : 0) + (z ? 1 : 0) - (o.z ? 1 : 0);
//			if (y && z) {
//				return -1;
//			} else if (o.y && o.z) {
//				return 1;
//			} else if (y || z) {
//				return -1;
//			} else {
//				return 1;
//			}
		} else {
			return this.x - o.x;
		}
	}
}
