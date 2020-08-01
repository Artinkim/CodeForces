import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E1_1374 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		Triple1[] arr = new Triple1[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Triple1(in.nextInt(), (in.nextInt() == 1), (in.nextInt() == 1));
		}
		Arrays.sort(arr);
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		int aCount = 0;
		int bCount = 0;
		long ans = 0;
		for (int i = 0; i < n; i++) {
			// System.out.println(arr[i].x + " " + arr[i].y + " " + arr[i].z);
			if (arr[i].y && arr[i].z) {
				bCount++;
				aCount++;
				ans += arr[i].x;
			} else if (arr[i].y) {
				a.add(i);
				ans += arr[i].x;
				aCount++;
			} else if (arr[i].z) {
				b.add(i);
				bCount++;
				ans += arr[i].x;
			}
			if ((aCount > k && bCount > k) && (b.size() > 0 && a.size() > 0)) {
				if ((arr[a.get(a.size() - 1)].x + arr[b.remove(b.size() - 1)].x) > arr[i].x) {
					aCount--;
					ans -= arr[a.remove(a.size() - 1)].x;
					bCount--;
					ans -= arr[b.remove(b.size() - 1)].x;
				} else {
					ans -= arr[i].x;
				}
			} else if (aCount > k && a.size() > 0) {
				aCount--;
				ans -= arr[a.remove(a.size() - 1)].x;
			} else if (bCount > k && b.size() > 0) {
				bCount--;
				ans -= arr[b.remove(b.size() - 1)].x;
			}
			if ((aCount >= k && bCount >= k) && (b.size() == 0 && a.size() == 0)) {
				break;
			}
		}

		if (aCount >= k && bCount >= k) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}
	}
}

class Triple1 implements Comparable<Triple1> {
	int x;
	boolean y;
	boolean z;

	Triple1(int x, boolean y, boolean z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public int compareTo(Triple1 o) {
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
