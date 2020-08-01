import java.util.ArrayList;
import java.util.Scanner;

public class E1375 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		ArrayList<Pair1> pairs = new ArrayList<Pair1>();
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			for (int j = i + 1; j < n; j++) {
				if (min > arr[j]) {
					min = arr[j];
					index = j;
				}
			}
			if (index != -1)
				pairs.add(new Pair1(i, index));
		}
		System.out.println(pairs.size());
		for (int i = 0; i < pairs.size(); i++) {
			System.out.println(pairs.get(i));
		}
	}
}

class Pair1 {
	int x;
	int y;

	public String toString() {
		return (x) + " " + (y + 1);
	}

	Pair1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
