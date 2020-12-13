import java.util.ArrayList;
import java.util.Scanner;

public class D1430 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			String s = in.next();

//			String s = "111010";
//			int n = s.length();
			ArrayList<Integer> arr = new ArrayList<Integer>(n);
			int last = -1;
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (s.charAt(i) == '1') {
					if (last == 1) {
						count++;
					} else {
						arr.add(count);
						count = 1;
					}
					last = 1;
				} else {
					if (last == 0) {
						count++;
					} else {
						arr.add(count);
						count = 1;
					}
					last = 0;
				}
			}
			arr.add(count);
			arr.remove(0);
//			for (int i = 0; i < arr.size(); i++) {
//				System.out.println(arr.get(i));
//			}
			int j = 0;
			int end = 0;
			int ans = 0;
			for (int i = 0; i < arr.size() - end; i++) {
				j = Math.max(i, j);
				
				if (j < arr.size()) {
					while ((j < arr.size()) && (arr.get(j) == 1))
						j++;
				}
				if (j < arr.size()) {
					arr.set(j,arr.get(j)-1);
				} else {
					end++;
				}
//				System.out.println(i + " " + (arr.size() - end) + " " + j);
				ans++;
			}
			System.out.println(ans);

		}
	}
}
