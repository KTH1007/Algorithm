import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int max = 0;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m][2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //소요 일
            arr[i][0] = a;
            //페이지 수
            arr[i][1] = b;
        }

        dfs(0, 0, 0);
        System.out.println(max);
    }

    static void dfs(int depth, int day, int totalPage) {
        if (depth == m) {
            max = Math.max(max, totalPage);
            return;
        }
        //챕터 포함
        if (day + arr[depth][0] <= n) dfs(depth + 1, day + arr[depth][0], totalPage + arr[depth][1]);
        //미포함
        if (day <= n) dfs(depth + 1, day, totalPage);
    }
}
