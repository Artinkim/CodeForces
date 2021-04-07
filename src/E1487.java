import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class E1487 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();
		int n4 = in.nextInt();
		int[][] arr = new int[4][];
		arr[0] = new int[n1];
		arr[1] = new int[n2];
		arr[2] = new int[n3];
		arr[3] = new int[n4];
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < arr[j].length; i++) {
				arr[j][i] = in.nextInt();
			}
		}
		for (int j = 0; j < 3; j++) {
			ArrayList<Integer>[] connections = new ArrayList[arr[j + 1].length];
			for (int i = 0; i < connections.length; i++) {
				connections[i] = new ArrayList<Integer>();
			}

			int m = in.nextInt();
			for (int i = 0; i < m; i++) {
				int first = in.nextInt() - 1;
				int second = in.nextInt() - 1;
				connections[second].add(first);
			}
			for (ArrayList<Integer> a : connections) {
				Collections.sort(a);
			}
			int[][] lookup = createSparseTable(arr[j]);
			for (int i = 0; i < arr[j + 1].length; i++) {
				int min = Integer.MAX_VALUE;
				int index = 0;
				for (int k = 0; k < connections[i].size(); k++) {
					// System.out.println(connections[i].get(k));
					if (index <= connections[i].get(k) - 1) {
						min = Math.min(min, query(lookup, index, connections[i].get(k) - 1));
					}
					// System.out.println(min);
					index = connections[i].get(k) + 1;
					// System.out.println(index + " index");
				}
				if (index <= arr[j].length - 1) {
					min = Math.min(min, query(lookup, index, arr[j].length - 1));
				}
				arr[j + 1][i] = min == Integer.MAX_VALUE ? min : min + arr[j + 1][i];
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n4; i++) {
			//System.out.println(arr[3][i]);
			min = Math.min(min, arr[3][i]);
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static int[][] createSparseTable(int[] arr) {
		int[][] lookup = new int[arr.length][(int) (Math.log(arr.length) / Math.log(2)) + 1];
		for (int i = 0; i < arr.length; i++) {
			lookup[i][0] = arr[i];
		}
		for (int j = 1; (1 << j) <= arr.length; j++) {
			for (int i = 0; (i + (1 << j) - 1) < arr.length; i++) { // (1<<j) = 2^j
				if (lookup[i][j - 1] < lookup[i + (1 << (j - 1))][j - 1]) {
					lookup[i][j] = lookup[i][j - 1];
				} else {
					lookup[i][j] = lookup[i + (1 << (j - 1))][j - 1];
				}
			}
		}
		return lookup;
	}

	static int query(int[][] lookup, int l, int r) {
		// System.out.println(l + " " + r);
		int j = (int) (Math.log(r - l + 1) / Math.log(2));
		// System.out.println(j);
		// System.out.println((1 << j));
		if (lookup[l][j] < lookup[r - (1 << j) + 1][j]) {
			return lookup[l][j];
		} else {
			return lookup[r - (1 << j) + 1][j];
		}
	}
}
