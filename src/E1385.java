import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class E1385 {
	static Stack<Integer> stack = new Stack<Integer>();
	static ArrayList<Integer>[] graphD;
	static ArrayList<Integer>[] graphU;
	static boolean[] visited;
	static boolean cyclic;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			graphD = new ArrayList[n];
			graphU = new ArrayList[n];
			
			for (int i = 0; i < n; i++) {
				graphD[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < n; i++) {
				graphU[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < m; i++) {
				if (in.nextInt() == 1) {
					graphD[in.nextInt() - 1].add(in.nextInt()-1);
				} else {
					graphU[in.nextInt() - 1].add(in.nextInt()-1);
				}
			}
			cyclic = false;
			stack.clear();
			visited = new boolean[n];
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					recurse(i);
				}
			}
			
			int[] map = new int[n];
			int tmp = stack.size();
			for(int i = 0;i<tmp;i++) {
				map[stack.pop()] = i;
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < graphD[i].size(); j++) {
					if(map[i] > map[graphD[i].get(j)]) {
						cyclic = true;
					} 
				}
			}
			
			if(cyclic) {
				System.out.println("NO");
				continue;
			}
			System.out.println("YES");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < graphD[i].size(); j++) {
					System.out.println((i+1)+" "+(graphD[i].get(j)+1));
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < graphU[i].size(); j++) {
					if(map[i] < map[graphU[i].get(j)]) {
						System.out.println((i+1)+" "+(graphU[i].get(j)+1));
					} else {
						System.out.println((graphU[i].get(j)+1)+" "+(i+1));
					}
				}
			}
			
		}
	}

	static void recurse(int vertex) {
//		recStack[vertex] = true;
		visited[vertex] = true;
		for (int i = 0; i < graphD[vertex].size(); i++) {
//			if(recStack[graphD[vertex].get(i)]) {
//				cyclic = true;
//				return;
//			}
			if (!visited[graphD[vertex].get(i)]) {
				recurse(graphD[vertex].get(i));
			}
			
		}
		stack.add(vertex);
	}
}
