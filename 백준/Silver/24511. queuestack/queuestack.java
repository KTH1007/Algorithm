import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] queueStack = new int[n];

        for (int i = 0; i < n; i++) {
            queueStack[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());

        int[] numArr = new int[n];
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
            if (queueStack[i] == 0) deque.add(numArr[i]);
        }


        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            deque.addFirst(num);
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb);

    }
}
