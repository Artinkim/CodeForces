import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class A1500 {
	public static void main(String[] args) { // TLE on test 8
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		HashMap<Integer, ArrayList<Pair8>> map = new HashMap<Integer, ArrayList<Pair8>>();
		ArrayIndexComparator comparator = new ArrayIndexComparator(arr);
		Integer[] indexes = comparator.createIndexArray();
		Arrays.sort(indexes, comparator);
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			int count = 0;
			int last = -1;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] == last) {
					count++;
				} else {
					count = 0;
				}
				if (count >= 3) {
					System.out.println((indexes[j] + 1) + " " + (indexes[j - 1] + 1) + " " + (indexes[j - 2] + 1) + " "
							+ (indexes[j - 3] + 1));
				}
				last = arr[j];
				int sum = arr[i] + arr[j];
				// System.out.println(sum);
				if (map.get(sum) == null) {
					map.put(sum, (new ArrayList<Pair8>()));
					map.get(sum).add(new Pair8(i, j));
				} else {
					Pair8 p = new Pair8(i, j);
					int overlap = -1;
					for (int k = 0; k < map.get(sum).size(); k++) {
						if (!map.get(sum).get(k).overlap(p)) {
							overlap = k;
							break;
						}
					}
					if (overlap == -1) {
						map.get(sum).add(p);
					} else {
						System.out.println("YES");
						System.out.println((indexes[map.get(sum).get(overlap).x] + 1) + " "
								+ (indexes[map.get(sum).get(overlap).y] + 1) + " " + (indexes[i] + 1) + " "
								+ (indexes[j] + 1));
						// System.out.println(arr[(map.get(sum).get(overlap).x + 1)] + " "+
						// arr[(map.get(sum).get(overlap).y + 1)] + " " + arr[(i + 1)] + " " + arr[(j +
						// 1)]);
						return;
					}

				}

			}
		}
		System.out.println("NO");
	}
}

class ArrayIndexComparator implements Comparator<Integer> {
	private final Integer[] array;

	public ArrayIndexComparator(Integer[] array) {
		this.array = array;
	}

	public Integer[] createIndexArray() {
		Integer[] indexes = new Integer[array.length];
		for (int i = 0; i < array.length; i++) {
			indexes[i] = i;
		}
		return indexes;
	}

	public int compare(Integer index1, Integer index2) {
		return array[index1].compareTo(array[index2]);
	}
}

class Pair8 {
	int x;
	int y;

	Pair8(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean overlap(Pair8 p) {
		if (p.x == this.x || p.x == this.y || p.y == this.x || p.y == this.y) {
			return true;
		}
		return false;
	}
}
