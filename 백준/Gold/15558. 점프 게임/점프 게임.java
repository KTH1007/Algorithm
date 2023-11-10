import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[][] bridge;
    static boolean flag = false;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bridge = new int[2][n];
        visited = new boolean[2][n];

        for (int i = 0; i < 2; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                bridge[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();

        if (flag) System.out.println(1);
        else System.out.println(0);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int go = current[1] + 1;
            int back = current[1] - 1;
            int swap = current[1] + k;
            int time = current[2];
            if (go >= n || swap >= n) {
                flag = true;
                return;
            }
            if (x == 0) {
                if (bridge[0][go] == 1 && time + 1 <= go && !visited[0][go]) {
                    visited[0][go] = true;
                    queue.add(new int[]{0, go, time + 1});
                }

                if (back >= 0 && time + 1 <= back && bridge[0][back] == 1 && !visited[0][back]) {
                    visited[0][back] = true;
                    queue.add(new int[]{0, back, time + 1});
                }

                if (bridge[1][swap] == 1 && time + 1 <= swap && !visited[1][swap]) {
                    visited[1][swap] = true;
                    queue.add(new int[]{1, swap, time + 1});
                }
            } else {
                if (bridge[1][go] == 1 && time + 1 <= go && !visited[1][go]) {
                    visited[1][go] = true;
                    queue.add(new int[]{1, go, time + 1});
                }

                if (back >= 0 && bridge[1][back] == 1 && time + 1 <= back && !visited[1][back]) {
                    visited[1][back] = true;
                    queue.add(new int[]{1, back, time + 1});
                }

                if (bridge[0][swap] == 1 && time + 1 <= swap && !visited[0][swap]) {
                    visited[0][swap] = true;
                    queue.add(new int[]{0, swap, time + 1});
                }
            }
        }
    }

}
