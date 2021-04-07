import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class C1474 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			// int[] arr = new int[n * 2];
			ArrayList<Integer> arr = new ArrayList<Integer>(6);
//			boolean[] band = new boolean[n * 2];
//			HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
			for (int i = 0; i < n * 2; i++) {
				arr.add(in.nextInt());
			}
			Collections.sort(arr);
			int last = arr.remove(arr.size()-1);
			boolean no = true;
			for (int i = 0; i < arr.size(); i++) {
				ArrayList<Integer> temp = new ArrayList<Integer>(arr);
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(last);
				list.add(temp.get(i));
				int x = last;
				temp.remove(i);
				boolean worked = true;
				for (int j = temp.size() - 1; j >= 0; j -= 2) {
					int a = temp.get(j);
					list.add(a);
					temp.remove(j);
					int index = Collections.binarySearch(temp, x - a);
					if (index < 0) {
						worked = false;
						break;
					}
					x = a;
					list.add(temp.remove(index));
				}
				if (worked) {
					System.out.println("YES");
					System.out.println(list.get(0)+list.get(1));
					for (int j = 0; j < list.size(); j+=2) {
						System.out.println(list.get(j)+" "+list.get(j+1));
					}
					no = false;
				}
			}
			if(no) {
				System.out.println("NO");
			}
			
//			for (int i = 0; i < n * 2; i++) {
//				if (map.get(arr[i]) == null) {
//					map.put(arr[i], new HashSet<Integer>());
//				}
//				map.get(arr[i]).add(i);
//			}
//
//			for (int i = 0; i < arr.length; i++) {
//				Arrays.fill(band, false);
//				HashMap<Integer, HashSet<Integer>> mp = new HashMap<Integer, HashSet<Integer>>(map);
//				mp.get(arr[i]).remove(i);
//				int x = arr[arr.length - 1];
//				band[arr.length - 1] = true;
//				band[i] = true;
//				for (int j = arr.length - 2; j >= 0; j -= 2) {
//					if(band[j]);
//					int a = arr[j];
//					if (mp.get(x-a).size() < 0) {
//						break;
//					}
//					mp.get(x-a).
//					x = a;
//				}
//			}
		}
	}
}
