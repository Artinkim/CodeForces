import java.util.Scanner;

public class C1399 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int[] arr = new int[51];
			for(int i = 0;i<n;i++) {
				arr[in.nextInt()]++;
			}
			int ans = 0;
			for(int i = 2;i<101;i++) {
				int tmp = 0;
				int end = (i/2);
				if(i%2 ==0) {
					tmp+=arr[i/2]/2;
				} else {
					end++;
				}
				for (int j = Math.max(1,i-50); j < end; j++) {
					tmp+=Math.min(arr[j],arr[i-j]);
				}
				ans = Math.max(ans,tmp);
			}
			System.out.println(ans+"");
		}
	}
}
