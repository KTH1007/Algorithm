import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] arr;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[12];

        dfs(0, 0);
        if (flag) System.out.println(sb);
        else System.out.println(-1);
    }

    static void dfs(int depth, int sum) {
        if (sum > n) return;
        if (sum == n) {
            count++;
            if (count == k) {
                flag = true;
                sb.append(arr[0]);
                for (int i = 1; i < depth; i++) {
                    sb.append("+").append(arr[i]);
                }
            }
            return;
        }

        for (int i = 1; i < 4; i++) {
            arr[depth] = i;
            dfs(depth + 1, sum + i);
        }
    }
}
