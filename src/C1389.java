import java.util.Arrays;
import java.util.Scanner;

public class C1389 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int[][] pairs = new int[10][10];
			boolean[][] halfmade = new boolean[10][10];
//			boolean[][] exists = new boolean[10][10];
			String str = in.next();
			int skip = -1;
			for (int i = 0; i < str.length(); i++) {
				
				for(int j = 0; j < 10;j++) {
					if(halfmade[j][str.charAt(i)-48]) {
						pairs[j][str.charAt(i)-48]++;
						halfmade[j][str.charAt(i)-48] = false;
						if(j == str.charAt(i)-48)
							skip = str.charAt(i)-48;
//						exists[j][str.charAt(i)-48] = true;
					}
				}
					
				for(int j = 0; j < 10;j++) {
					if(skip == j) {
						skip = -1;
						continue;
					}
					halfmade[str.charAt(i)-48][j] = true;
				}
				
//				for (int k = 0; k < 10; k++)
//				pairs[str.charAt(i-1)-48][str.charAt(i)-48]++;
			}
//			pairs[str.charAt(str.length()-1)-48][str.charAt(0)-48]++;
			int ans = 0;
			for(int i = 0; i < 10;i++) {
				for (int j = 0; j < 10; j++) {
					if(i == j && halfmade[i][j]) {
						ans = Math.max(ans, pairs[i][j]*2+1);
					} else {
						ans = Math.max(ans, pairs[i][j]*2);
					}
				}
			}
			System.out.println(str.length()-ans);
		}
	}
}
