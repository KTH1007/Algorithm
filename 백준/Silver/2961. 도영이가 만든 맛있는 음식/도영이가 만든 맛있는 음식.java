import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int diff = Integer.MAX_VALUE;
    static int n;
    static int[][] food;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        food = new int[n][2];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            food[i][0] = Integer.parseInt(st.nextToken());
            food[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(diff);
    }

    static void dfs(int depth) {
        if (depth == n) {
            int s = 1;
            int b = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    count++;
                    s *= food[i][0];
                    b += food[i][1];
                }
            }
            if (count == 0) return;
            diff = Math.min(diff, Math.abs(s - b));
            return;
        }
        //음식 선택
        visited[depth] = true;
        dfs(depth + 1);
        //음선 미선택
        visited[depth] = false;
        dfs(depth + 1);
    }
}




