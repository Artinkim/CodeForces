import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D1365 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
//		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
//		map.put('.',0);
//		map.put('#',1);
//		map.put('G',2);
//		map.put('B',3);
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		while (t-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[][] grid = new int[n][m];
			int goodCount1 = 0;

			for (int i = 0; i < n; i++) {
				String str = in.next();
				for (int j = 0; j < m; j++) {
					// grid[i][j] = map.get(str.charAt(j));
					if (str.charAt(j) == '.') {
						grid[i][j] = 0;
					} else if (str.charAt(j) == '#') {
						grid[i][j] = 1;
					} else if (str.charAt(j) == 'G') {
						grid[i][j] = 2;
						goodCount1++;
					} else {
						grid[i][j] = 3;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (grid[i][j] == 3) {
						for (int k = 0; k < 4; k++) {
							if ((i + dx[k] < 0 || i + dx[k] > n - 1) || (j + dy[k] < 0 || j + dy[k] > m - 1))
								continue;
							if (grid[i + dx[k]][j + dy[k]] == 0)
								grid[i + dx[k]][j + dy[k]] = 1;
						}
					}
				}
			}

			if (grid[n - 1][m - 1] == 1) {
				if (goodCount1 == 0) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			} else {
				Queue<Pair> queue = new LinkedList<Pair>();
				queue.add(new Pair(n - 1, m - 1));
				boolean bad = false;
				int goodCount2 = 0;
				boolean[][] visited = new boolean[n][m];
				while (!queue.isEmpty()) {
					Pair current = queue.poll();
					for (int k = 0; k < 4; k++) {
						if ((current.x + dx[k] < 0 || current.x + dx[k] > n - 1)
								|| (current.y + dy[k] < 0 || current.y + dy[k] > m - 1))
							continue;
						if (visited[current.x + dx[k]][current.y + dy[k]])
							continue;
						if (grid[current.x + dx[k]][current.y + dy[k]] == 1)
							continue;
						if (grid[current.x + dx[k]][current.y + dy[k]] == 3) {
							bad = true;
							queue.clear();
							break;
						} else if (grid[current.x + dx[k]][current.y + dy[k]] == 2)
							goodCount2++;
						queue.add(new Pair(current.x + dx[k], current.y + dy[k]));
						visited[current.x + dx[k]][current.y + dy[k]] = true;
					}
				}
				if (bad) {
					System.out.println("No");
				} else if (goodCount1 == goodCount2) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}
	}
}

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
