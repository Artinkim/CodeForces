import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class D1461 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int q = in.nextInt();
			ArrayList<Integer> arr = new ArrayList<Integer>(n);
			for (int i = 0; i < n; i++) {
				arr.add(in.nextInt());
			}
			HashSet<Integer> possibleSums = new HashSet<Integer>();
			possibleSums.add(recursive(arr, possibleSums, -1));
//			for (Object i : possibleSums.toArray()) {
//				System.out.println((Integer) i);
//			}
			for (int i = 0; i < q; i++) {
				if (possibleSums.contains(in.nextInt())) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}
	}

	static int recursive(ArrayList<Integer> arr, HashSet<Integer> possibleSums, int lastSize) {
//		System.out.println();
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.print(arr.get(i) + " ");
//		}

		if (arr.size() == 0)
			return 0;

		if (arr.size() == lastSize) {
			int sum = arr.size() * arr.get(0);
			possibleSums.add(sum);
			return sum;
		}

		if (arr.size() == 1) {
			possibleSums.add(arr.get(0));
			// System.out.println("1 " + arr.get(0));
			return arr.get(0);
		} else {
			int high = -1;
			int low = Integer.MAX_VALUE;
			for (int i = 0; i < arr.size(); i++) {
				high = Math.max(arr.get(i), high);
				low = Math.min(arr.get(i), low);
			}
			int mid = (low + high) / 2;
			ArrayList<Integer> left = new ArrayList<Integer>();
			ArrayList<Integer> right = new ArrayList<Integer>();
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i) > mid) {
					right.add(arr.get(i));
				} else {
					left.add(arr.get(i));
				}
			}
			int sum = recursive(left, possibleSums, arr.size()) + recursive(right, possibleSums, arr.size());
			// System.out.println(arr.size() + " " + sum);
			possibleSums.add(sum);
			return sum;
		}
	}
}
