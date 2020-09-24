import java.util.HashMap;
import java.util.Scanner;

public class B1393 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		// TreeSet<Pair3> tm = new TreeSet<Pair3>();
		HashMap<Integer, Integer> tm = new HashMap<Integer, Integer>();
		int twos = 0;
		int fours = 0;
		int sixes = 0;
		int eights = 0;
		for (int i = 0; i < n; i++) {
			int tmp = in.nextInt();
			int tmp2 = tm.containsKey(tmp) ? tm.get(tmp) : 0;
			if (tmp2 == 7) {
				eights++;
				sixes--;
			} else if (tmp2 == 5) {
				sixes++;
				fours--;
			} else if (tmp2 == 3) {
				fours++;
				twos--;
			} else if (tmp2 == 1) {
				twos++;
			}
			tm.put(tmp, tmp2 + 1);
		}
//		for(Entry<Integer, Integer> entry : tm.entrySet()) {
//			
//			  Integer value = entry.getValue();
//		}
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			if (in.next().equals("+")) {
				
				int tmp = in.nextInt();
				//System.out.println("+"+tmp);
				int tmp2 = tm.containsKey(tmp) ? tm.get(tmp) : 0;
				if (tmp2 == 7) {
					eights++;
					sixes--;
				} else if (tmp2 == 5) {
					sixes++;
					fours--;
				} else if (tmp2 == 3) {
					fours++;
					twos--;
				} else if (tmp2 == 1) {
					twos++;
				}
				tm.put(tmp, tmp2 + 1);
			} else {
				int tmp = in.nextInt();
				//System.out.println("-"+tmp);
				int tmp2 = tm.get(tmp);
				if (tmp2 == 8) {
					eights--;
					sixes++;
				} else if (tmp2 == 6) {
					sixes--;
					fours++;
				} else if (tmp2 == 4) {
					fours--;
					twos++;
				} else if (tmp2 == 2) {
					twos--;
				}
				tm.put(tmp, tmp2 - 1);
			}
//			for(Entry<Integer, Integer> entry : tm.entrySet()) {
//				Integer key = entry.getKey();
//				  Integer value = entry.getValue();
//
//				  System.out.println(key + " => " + value);
//			}
//			Entry<Integer, Integer> tmp = tm.pollLastEntry();
//			System.out.println(tmp.getValue()+" value");
			//System.out.println(twos+" "+fours+" "+sixes+" "+eights);
			if (eights > 0) {
				System.out.println("YES");
			} else if (fours > 1 || sixes > 1) {
				System.out.println("YES");
			} else if (fours == 1 && sixes == 1) {
				System.out.println("YES");
			} else if (twos >= 1 && sixes == 1) {
				System.out.println("YES");
			} else if (twos >= 2 && fours == 1) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

//			if(tmp.getValue() >=4) {
//				if(tmp.getValue()>=8) {
//					System.out.println("Yes");
//				} else if(tmp.getValue()>=6) {
//					Entry<Integer, Integer> tmp2 = tm.lastEntry();
//					System.out.println(tmp2.getValue()+" value 2nd");
//					if(tmp2.getValue() >=2) {
//						System.out.println("Yes");
//					} else {
//						System.out.println("NO");
//					}
//				} else {
//					Entry<Integer, Integer> tmp2 = tm.lastEntry();
//					if(tmp2.getValue() >=4) {
//						System.out.println("Yes");
//					} else {
//						System.out.println("NO");
//					}
//				}
//			} else {
//				System.out.println("NO");
//			}
//			tm.put(tmp.getKey(),tmp.getValue());
//			
		}

	}
}
//class Pair3 implements Comparator,Comparable{
//	int x;
//	int y;
//	Pair3(int x,int y) {
//		this.x = x;
//		this.y = y;
//	}
//	
//	@Override
//	public int compare(Object o1, Object o2) {
//		// TODO Auto-generated method stub
//		return ((Pair3) o1).y-((Pair3) o2).y;
//	}
//
//	@Override
//	public int compareTo(Object o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//}
