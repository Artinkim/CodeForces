import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C1366 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		boolean[][] grid;
		while (t-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			grid = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					grid[i][j] = (in.nextInt() == 1);
				}
			}
			ArrayList<String> paths = new ArrayList<String>();
			Queue<Triple> queue = new LinkedList<Triple>();
			queue.add(new Triple(0, 0, "" + grid[0][0]));
			while (!queue.isEmpty()) {
				Triple current = queue.poll();
				if (current.x == n - 1 && current.y == m - 1) {
					paths.add(current.z);
					continue;
				}
				if (current.x < n - 1)
					queue.add(new Triple(current.x + 1, current.y, current.z + grid[current.x + 1][current.y]));
				if (current.y < m - 1)
					queue.add(new Triple(current.x, current.y + 1, current.z + grid[current.x][current.y + 1]));
			}
			int count = 0;
			for (int i = 0; i < paths.size(); i++) {
				String str = paths.get(i);
				for (int j = 0; j < str.length()/2; j++) {
					if(str.charAt(j) != str.charAt(str.length()-j-1))
						count++;
				}
			}
			System.out.println(count);
		}
	}
}

class Triple {
	int x;
	int y;
	String z;

	Triple(int x, int y, String z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
