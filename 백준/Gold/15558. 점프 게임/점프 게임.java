import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[2][n];
        arr = new int[2][n];
        String s = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[0][i] = s.charAt(i) - '0';
        }
        s = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[1][i] = s.charAt(i) - '0';
        }
        BFS();
    }

    static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int flag = current[2];  //0이면 왼쪽 1이면 오른쪽
            int time = current[1];
            int go = current[0] + 1;
            int back = current[0] - 1;
            int swap = current[0] + k;

            if (go >= n || swap >= n) {
                System.out.println(1);
                return;
            }
            if (flag == 0) {
                if (arr[0][go] == 1 && time + 1 <= go && !visited[0][go]) {
                    visited[0][go] = true;
                    queue.add(new int[]{go, time + 1, 0});
                }

                if (back >= 0 && arr[0][back] == 1 && time + 1 <= back && !visited[0][back]) {
                    visited[0][back] = true;
                    queue.add(new int[]{back, time + 1, 0});
                }
                if (arr[1][swap] == 1 && time + 1 <= swap && !visited[1][swap]) {
                    visited[1][swap] = true;
                    queue.add(new int[]{swap, time + 1, 1});
                }
            } else {
                if (arr[1][go] == 1 && time + 1 <= go && !visited[1][go]) {
                    visited[1][go] = true;
                    queue.add(new int[]{go, time + 1, 1});
                }
                if (back >= 0 && arr[1][back] == 1 && time + 1 <= back && !visited[1][back]) {
                    visited[1][back] = true;
                    queue.add(new int[]{back, time + 1, 1});
                }
                if (arr[0][swap] == 1 && time + 1 <= swap && !visited[0][swap]) {
                    visited[0][swap] = true;
                    queue.add(new int[]{swap, time + 1, 0});
                }
            }
        }
        System.out.println(0);
    }

}
