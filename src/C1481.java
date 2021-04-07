import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class C1481 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[] start = new int[n];
			for (int i = 0; i < n; i++) {
				start[i] = in.nextInt() - 1;
			}
			ArrayList<Integer>[] colorsNeeded = new ArrayList[n];
			for (int i = 0; i < colorsNeeded.length; i++) {
				colorsNeeded[i] = new ArrayList<Integer>();
			}
			int[] desiredHas = new int[n];
			Arrays.fill(desiredHas, -1);
			for (int i = 0; i < n; i++) {
				int currentDesire = in.nextInt() - 1;
				desiredHas[currentDesire] = i;
				if (start[i] != currentDesire) {
					colorsNeeded[currentDesire].add(i);
				}
			}
			int paintOverStart = 0;
			int[] paintersPlanks = new int[m];
			for (int i = 0; i < m; i++) {
				int currentPainterColor = in.nextInt() - 1;
				if (colorsNeeded[currentPainterColor].size() > 0) {
					int index = colorsNeeded[currentPainterColor].remove(colorsNeeded[currentPainterColor].size() - 1);
					for (int j = paintOverStart; j <= i; j++) {
						paintersPlanks[j] = index;
					}
					paintOverStart = i + 1;
				} else if (desiredHas[currentPainterColor] == -1) {
					if (paintOverStart == i)
						paintOverStart = i;
				} else {
					int index = desiredHas[currentPainterColor];
					for (int j = paintOverStart; j <= i; j++) {
						paintersPlanks[j] = index;
					}
					paintOverStart = i + 1;
				}
			}
			for (int i = 0; i < n; i++) {
				if (colorsNeeded[i].size() != 0) {
					paintOverStart = -1;
				}
			}
			if (paintOverStart == m) {
				System.out.println("YES");
				for (int i = 0; i < m; i++) {
					System.out.print((paintersPlanks[i] + 1) + " ");
				}
			} else {
				System.out.println("NO");
			}
		}
	}
}
