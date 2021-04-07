import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class A1500Better {
	public static void main(String[] args) { // SOMEHOW STILL ???? TLE on test 8
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		HashMap<Integer, ArrayList<Pair8>> map = new HashMap<Integer, ArrayList<Pair8>>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
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
						System.out.println((map.get(sum).get(overlap).x + 1) + " " + (map.get(sum).get(overlap).y + 1)
								+ " " + (i + 1) + " " + (j + 1));
						// System.out.println(arr[(map.get(sum).get(overlap).x + 1)] + " "+
						// arr[(map.get(sum).get(overlap).y + 1)] + " " + arr[(i + 1)] + " " + arr[(j +
						// 1)]);
						return;
					}
					if (map.get(sum).size() >= 4) {
						int similarIndex = -1;
						String s = "";
						if (map.get(sum).get(0).x == map.get(sum).get(1).x) {
							s += (map.get(sum).get(0).y + 1) + " " + (map.get(sum).get(1).y + 1);
							similarIndex = map.get(sum).get(0).x;
						} else if (map.get(sum).get(0).y == map.get(sum).get(1).x) {
							s += (map.get(sum).get(0).x + 1) + " " + (map.get(sum).get(1).y + 1);
							similarIndex = map.get(sum).get(0).y;
						} else if (map.get(sum).get(0).x == map.get(sum).get(1).y) {
							s += (map.get(sum).get(0).y + 1) + " " + (map.get(sum).get(1).x + 1);
							similarIndex = map.get(sum).get(0).x;
						} else {
							s += (map.get(sum).get(0).x + 1) + " " + (map.get(sum).get(1).x + 1);
							similarIndex = map.get(sum).get(0).y;
						}
						if (map.get(sum).get(2).x == similarIndex) {
							s += (map.get(sum).get(2).y + 1) + " ";
						} else {
							s += (map.get(sum).get(2).x + 1) + " ";
						}
						if (map.get(sum).get(3).x == similarIndex) {
							s += (map.get(sum).get(3).y + 1) + " ";
						} else {
							s += (map.get(sum).get(3).x + 1) + " ";
						}
						System.out.println("YES");
						System.out.println(s);
					}
				}

			}
		}
		System.out.println("NO");
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
