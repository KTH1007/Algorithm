import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Map<Integer, Queue<String>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Queue<String> queue = new ArrayDeque<>();
            while (st.hasMoreTokens()) {
                queue.add(st.nextToken());
            }

            map.put(i, queue);
        }

        String l = br.readLine();
        st = new StringTokenizer(l);


        int size = st.countTokens();
        for (int i = 0; i < size; i++) {
            String word = st.nextToken();
            boolean contain = false;
            for (int j = 0; j < n; j++) {
                Queue<String> queue = map.get(j);
                if (queue.isEmpty()) continue;

                if (queue.peek().equals(word)) {
                    queue.poll();
                    map.put(j, queue);
                    contain = true;
                }
            }
            if (!contain) {
                System.out.println("Impossible");
                return;
            }
        }

        boolean flag = true;
        for (int i = 0; i < n; i++) {
            Queue<String> queue = map.get(i);
            if (!queue.isEmpty()) {
                flag = false;
            }
        }

        if (flag) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
    }
}
