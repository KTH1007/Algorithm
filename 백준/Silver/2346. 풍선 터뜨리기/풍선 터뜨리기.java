import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) deque.add(new int[]{Integer.parseInt(st.nextToken()), i});

        int[] current = deque.poll();
        int x = current[0];  // 풍선 안에 값
        int index = current[1];  // 인덱스 값

        sb.append(index).append(" ");

        while (!deque.isEmpty()) {
            if (x < 0) {
                for (int i = 1; i < Math.abs(x); i++) {
                    int[] temp = deque.pollLast();
                    deque.addFirst(temp);
                }
                current = deque.pollLast();

            } else {
                for (int i = 1; i < x; i++) {
                    int[] temp = deque.poll();
                    deque.add(temp);
                }
                current = deque.poll();
            }

            x = current[0];
            index = current[1];
            sb.append(index).append(" ");

        }

        System.out.println(sb);
    }


}


