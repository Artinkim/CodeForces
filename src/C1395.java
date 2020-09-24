import java.util.Arrays;
import java.util.Scanner;

public class C1395 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] a = new int[n];
		int[] b = new int[m];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		for (int i = 0; i < m; i++) {
			b[i] = in.nextInt();
		}
//		int n = 8;
//		int m = 5;
//		int[] a = {179, 261, 432, 162, 82, 43, 10, 38};
//		int[] b = {379, 357, 202, 184, 197};
		boolean passed = false;
		for(int k = 0;k<512;k++) {
			for (int i = 0; i < n; i++) {
				passed = false;
				for (int j = 0; j < m; j++) {
					if(((a[i]&b[j])|k) ==k) {
						passed = true;
						break;
					}
				}
				if(!passed)
					break;
			 }
			if(passed) {
				System.out.println(k);
				break;
			} 
		}
//		int[] arr = new int[n];
//		Arrays.fill(arr,10000);
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.println(a[i]+" & "+b[j]+" = "+(a[i] & b[j]));
//				arr[i] = Math.min(arr[i],a[i] & b[j]);
//			}
//		}
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i]+" ");
//		}
//		System.out.println();
//		Arrays.sort(arr);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i]+" ");
//		}
//		System.out.println();
//		int ans = 0;
//		for (int i = 0; i < n; i++) {
//			System.out.print(ans+" ");
//			ans = ans|arr[i];
//		}
//		System.out.println(ans);
	}
}
