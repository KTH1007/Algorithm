import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> c = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Queue<Integer> w = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            c.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            w.add(Integer.parseInt(st.nextToken()));
        }

        boolean flag = true;

        while (!w.isEmpty()) {
            if (c.isEmpty()) {
                flag = false;
                break;
            }

            int box = c.poll();
            int want = w.poll();

            if (box < want) {
                flag = false;
                break;
            }

            box -= want;
            if (box > 0) {
                c.add(box);
            }
        }


        if (flag) {
            System.out.println(1);
        } else System.out.println(0);
    }
}
