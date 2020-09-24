import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C1388 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[] cityPopCount = new int[n+1];
			int[] cityHappyScore = new int[n+1];
			for(int i =0;i<n;i++) {
				cityPopCount[i] = in.nextInt();
			}
			for(int i =0;i<n;i++) {
				cityHappyScore[i] = in.nextInt();
			}
			ArrayList<Integer>[] graph = new ArrayList[n];
			for (int i = 0; i < graph.length; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			for(int i = 0;i<n-1;i++) {
				graph[in.nextInt()].add(in.nextInt());
			}
			ArrayList<Integer>[] passthroughCities = new ArrayList[n+1];
			for (int i = 0; i < passthroughCities.length; i++) {
				passthroughCities[i] = new ArrayList<Integer>();
			}
			Queue<History> queue = new LinkedList<History>();
			boolean[] visited = new boolean[n];
			int[] distances = new int[n+1];
			boolean possible = true;
			while(!queue.isEmpty()) {
				History current = queue.poll();
				passthroughCities[current.x] = current.list;
				if(cityHappyScore[current.x] > current.t-current.b) {
					
				}
				for(int i = 0;i<graph[current.x].size();i++) {
					int neighbor = graph[current.x].get(i);
					if(!visited[neighbor]) {
						ArrayList copy = new ArrayList<Integer>(current.list);
						copy.add(current.x);
						queue.add(new History(current.x,copy));
						visited[neighbor] = true;
					}
				}
			}
			int[] cityPassingCount = new int[n];
			for(int i = 0;i<n+1;i++) {
				for (int j = 0; j < passthroughCities[i].size(); j++) {
					cityPassingCount[i]+=cityPopCount[passthroughCities[i].get(j)];
				}
				if(cityPassingCount) { 
					
					
				}
			}
			int count = 0;
			for(int i = n-1;i>=0;i--) {
				for(int j = 0;j<citiesAtDistances[i].size();j++) {
					cityPopCount[citiesAtDistances[i].get(j)]
				}
				count+=citiesAtDistances[i];
				
			}
		}
	}
}

class Pair2 {
	int x;
	int y;

	Pair2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
class History {
	int x;
	int b;
	int t;
	ArrayList<Integer> list;
	History(int x,int b,int t,ArrayList<Integer> list) {
		this.x = x;
		this.b = b;
		this.t = t;
		this.list = list;
	}
}
