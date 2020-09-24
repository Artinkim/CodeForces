import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D1401 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			ArrayList<Integer>[] graph = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;
			graph[a].add(b);
			for (int i = 0; i < n - 2; i++) {
				graph[in.nextInt() - 1].add(in.nextInt() - 1);
			}
			int m = in.nextInt();
			int[] primes = new int[m];
			for (int i = 0; i < m; i++) {
				primes[i] = in.nextInt();
			}
			int[] vertCount = new int[n];
			boolean[] visited = new boolean[n];
			visited[a] = true;
			visited[b] = true;
			dfs(a, visited, graph, vertCount);
			dfs(b, visited, graph, vertCount);
			int[] edgeWeights = new int[n - 1];
			int k = 0;
			for (int j = 0; j < n; j++) {
				for (int i = 0; i < graph[j].size(); i++) {
					edgeWeights[k] = vertCount[j] * vertCount[graph[j].get(i)];
					k++;
				}
			}

//			Queue<Integer> queue = new LinkedList<Integer>();
//			while (!queue.isEmpty()) {
//				int current = queue.poll();
//				if (visited[current]) {
//					continue;
//				}
//				for (int i = 0; i < graph[current].size(); i++) {
//					queue.add(graph[current].get(i));
//					visited[graph[current].get(i)] = true;
//				}
//
//			}
		}
	}

	static int dfs(int current, boolean[] visited, ArrayList<Integer>[] graph, int[] vertCount) {
		int sum = 1;
		for (int i = 0; i < graph[current].size(); i++) {
			if (visited[graph[current].get(i)]) {
				continue;
			}
			visited[graph[current].get(i)] = true;
			sum += dfs(graph[current].get(i), visited, graph, vertCount);

		}
		vertCount[current] = sum;
		return sum;
	}
}
