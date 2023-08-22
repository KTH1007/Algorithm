import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k, s, x, y;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        List<Node> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    list.add(new Node(i, j, arr[i][j], 0));
                }
            }
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.virus - o2.virus;
            }
        });
        for (Node node : list) {
            queue.add(node);
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        bfs();

        System.out.println(arr[x - 1][y - 1]);

    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.time == s) return;
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 0) {
                    arr[nx][ny] = current.virus;
                    queue.add(new Node(nx, ny, current.virus, current.time + 1));
                }
            }
        }
    }

    static class Node {
        int x, y, virus, time;

        public Node(int x, int y, int virus, int time) {
            this.x = x;
            this.y = y;
            this.virus = virus;
            this.time = time;
        }
    }


}


