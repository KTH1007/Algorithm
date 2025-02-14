import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int max = 1440;

        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        int sum = 0;
        while (!queue.isEmpty()) {
            int a = queue.poll();

            if (queue.isEmpty()) {
                sum += a;
                break;
            }

            int b = queue.poll();
            sum += b;
            queue.add(a - b);
        }

        if (sum > max) System.out.println(-1);
        else System.out.println(sum);
    }

}
