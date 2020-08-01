import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class D1363 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int k = in.nextInt();
			ArrayList<HashSet<Integer>> arr = new ArrayList<HashSet<Integer>>();
			in.nextLine();
			String nums = "";
			for (int j = 1; j < n+1; j++)
				nums += " " + j;
			for (int j = 0; j < k; j++) {
				arr.add(new HashSet<Integer>());
				int p = in.nextInt();
				for (int w = 0; w < p; w++) {
					arr.get(j).add(in.nextInt());
				}

			}
			//System.out.println(t+" "+n+" "+k+" "+nums);
			int high = n;
			int low = 0;
			int max = 0;
			while (true) {
				System.out.println("? " + (high - low) + nums.substring(low*2, high*2));
				System.out.flush();
				int query = in.nextInt();
				if(high-low ==1) {
					if(query != max)
						low++;
					break;
				}
				if (query < max) {
					int temp = high;
					high += (high - low)/2;
					low = temp;
				} else {
					max = query;
					high = low+(high-low)/ 2;
				}
			}
			
			String answer = "! ";
			for (int j = 0; j < k; j++) {
				if (arr.get(j).contains(low+1)) {
					nums = "";
					for (int w = 1; w < n+1; w++) {
						if(arr.get(j).contains(w))
							continue;
						nums += " " + w;
					}
					System.out.println("? " + (n-arr.get(j).size()) + nums);
					System.out.flush();
					answer += " " + (in.nextInt());
				} else {
					answer += " " + max;
				}
			}
			System.out.println(answer);
		}
	}
}
