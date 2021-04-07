import java.util.HashMap;
import java.util.Scanner;

public class G1506 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			String s = in.next();
			if (s.length() == 1) {
				System.out.println(s);
				continue;
			}
			int[] letters = new int[26]; // 'a' = 97
			for (int i = 0; i < s.length(); i++) {
				letters[(s.charAt(i) - 97)]++;
			}
			int finalLength = 0;
			for (int x : letters) {
				if (x != 0) {
					finalLength++;
				}
			}
			// LL list = new LL(s);
			Node head = new Node(s.charAt(0));
			Node node = new Node(s.charAt(1));
			head.next = node;
			for (int i = 2; i < s.length(); i++) {
				Node temp = new Node(s.charAt(i));
				node.next = temp;
				node = temp;
			}
			Node n = head;
//			while (node.next != null) {
//				// System.out.println(n);
//				System.out.print(n.data + " ");
//				n = n.next;
//			}
			// System.out.println("Final length: " + finalLength);
//			long startTime = System.nanoTime();

			System.out.println(recurse(head, new HashMap<String, String>(), letters, s.length(), finalLength));
//			long endTime = System.nanoTime();
//
//			long duration = (endTime - startTime);
//			System.out.println(duration);
		}
	}

	public static String recurse(Node head, HashMap<String, String> map, int[] letters, int size, int finalLength) {
		// System.out.println(list.size + " " + list.head.data + " " + list.toString());
		StringBuilder sb = new StringBuilder();
		Node n = head;
		while (n != null) {
			sb.append(n.data);
			n = n.next;
		}
		String s = sb.toString();

		if (size == finalLength) {
			return s;
		}
		if (map.containsKey(s)) {
			return map.get(s);
		}
//		} else if (s.length() == finalLength + 1) {
//			int i = 0;
//			while (letters[s.charAt(i) - 97] <= 1) {
//				i++;
//			}
//			return s.substring(0, i) + s.substring(i + 1);
//		}
		String max = "";
		Node node = head;
		Node previous = null;
		size--;
		while (node != null) {
			// System.out.println(node.data);
			if (letters[node.data - 97] <= 1) {
				previous = node;
				node = node.next;
				continue;
			}
			letters[node.data - 97]--;
			if (previous == null) {
				head = node.next;
			} else {
				previous.next = node.next;
			}
			String returnedAnswer = recurse(head, map, letters, size, finalLength);
			if (previous == null) {
				head = node;
			} else {
				previous.next = node;
			}
			letters[node.data - 97]++;
			if (returnedAnswer.compareTo(max) > 0) {
				max = returnedAnswer;
			}
			previous = node;
			node = node.next;
		}

		map.put(s, max);
		return max;
//		i++;
//		while (letters[s.charAt(i) - 97] <= 1) {
//			i++;
//		}
//		letters[s.charAt(i) - 97]--;
//		String second = recurse(s.substring(0, i) + s.substring(i + 1), map, letters, finalLength);
//		letters[s.charAt(i) - 97]++;
//		System.out.println(s);
//		System.out.println(first + " " + second);

	}
}

class Node {
	Node next;
	Character data;

	public Node(Character data) {
		next = null;
		this.data = data;
	}
}

//class LL {
//	Node head;
//	Node tail;
//
//	public LL(String s) {
//		head = new Node(s.charAt(0));
//		Node temp = new Node(s.charAt(1));
//		head.next = temp;
//		tail = temp;
//		for (int i = 2; i < s.length(); i++) {
//			temp = new Node(s.charAt(i));
//			tail.next = temp;
//			tail = temp;
//		}
//	}
//
//	public void add(Character data) {
//		Node temp = new Node(data);
//		tail.next = temp;
//		tail = temp;
//	}
//
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		Node node = head;
//		while (node != null) {
//			sb.append(node.data);
//			node = node.next;
//		}
//		return sb.toString();
//	}
//}