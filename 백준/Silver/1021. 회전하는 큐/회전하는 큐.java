import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt = 0;
		LinkedList<Integer> deque = new LinkedList<Integer>();
		int[] arr = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			deque.offer(i);
		}
		for (int i = 0; i < m; i++) {
			int t = deque.indexOf(arr[i]);
			int half;
			if (deque.size() % 2 == 0) {
				half = deque.size() / 2 - 1;
			} else {
				half = deque.size() / 2;
			}
			if (t <= half) {
				for (int j = 0; j < t; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					cnt++;
				}
			} else {
				for (int j = 0; j < deque.size() - t; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					cnt++;
				}
			}
			deque.pollFirst();
		}
		System.out.println(cnt);
		sc.close();
	}
}