import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        int temp = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            if (temp == 0) count++;
            if (temp + queue.peek() <= m) {
                temp += queue.poll();
            } else {
                temp = 0;
            }
        }

        System.out.println(count);
        br.close();
    }
}
