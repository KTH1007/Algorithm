import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[101];
    static int[] count = new int[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
        }
        BFS();
    }

    static void BFS() {
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
                //방문하지 않았고 사디라나 뱀이 없는 경우
                if (count[current + i] == 0 && arr[current + i] == 0) {
                    count[current + i] = count[current] + 1;
                    queue.add(current + i);
                }
                //사다리나 뱀이 있는 경우
                else if (arr[current + i] != 0) {
                    int move = arr[current + i];
                    //방문하지 않았던 곳
                    if (count[move] == 0) {
                        count[move] = count[current] + 1;
                        queue.add(move);
                    }
                }
            }
        }
    }

}