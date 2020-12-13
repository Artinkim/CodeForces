import java.util.HashMap;
import java.util.Scanner;

public class D1452 {
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		map.put(0, 0);
		map.put(1, 1);
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
		int n = 4;
		System.out.println(((fib(n)%998244353)*exponentMod(exponentMod(2,n,998244353),998244351,998244353))%998244353);
	}

	static int fib(int i) {
		if (!map.containsKey(i)) {
			map.put(i, fib(i - 1) + fib(i - 2));
		}
		return map.get(i);
	}

	static int exponentMod(int A, int B, int C) {
		// Base cases
		if (A == 0)
			return 0;
		if (B == 0)
			return 1;

		// If B is even
		long y;
		if (B % 2 == 0) {
			y = exponentMod(A, B / 2, C);
			y = (y * y) % C;
		}

		// If B is odd
		else {
			y = A % C;
			y = (y * exponentMod(A, B - 1, C) % C) % C;
		}

		return (int) ((y + C) % C);
	}
}
