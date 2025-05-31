import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int count = 0;

        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        while (n-- > 0) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while (!pq.isEmpty()) {
            if (t <= 0 || pq.peek() < h || pq.peek() == 1) break;

            int temp = pq.poll() / 2;
            pq.add(temp);
            count++;
            t--;
        }

        if (pq.peek() >= h) {
            System.out.println("NO");
            System.out.println(pq.peek());
        } else {
            System.out.println("YES");
            System.out.println(count);
        }
    }
}
