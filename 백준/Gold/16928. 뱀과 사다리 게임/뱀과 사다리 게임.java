import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr = new int[101];
    static int[] count = new int[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
        }
        bfs();

    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == 100) {
                System.out.println(count[100]);
                return;
            }
            for (int i = 1; i <= 6; i++) {
                if (current + i > 100) continue;
                //방문하지 않고 뱀이나 사다리가 없는 경우
                if (count[current + i] == 0 && arr[current + i] == 0) {
                    count[current + i] = count[current] + 1;
                    queue.add(current + i);
                } else if (arr[current + i] != 0) { //사다리나 뱀이 있는 경우
                    int move = arr[current + i];
                    //방문하지 않은 곳
                    if (count[move] == 0) {
                        count[move] = count[current] + 1;
                        queue.add(move);
                    }
                }
            }
        }
    }

}
