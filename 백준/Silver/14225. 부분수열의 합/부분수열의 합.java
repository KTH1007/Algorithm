import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] answer;
    static int[] s;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;

        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
            max += s[i];
        }

        answer = new int[max + 2];

        dfs(0, 0);
        for (int i = 1; i < answer.length; i++) {
            if (answer[i] == 0) {
                System.out.println(i);
                break;
            }
        }
    }

    private static void dfs(int depth, int sum) {
        if (depth == n) {
            answer[sum] = 1;
            return;
        }

        dfs(depth + 1, sum + s[depth]);
        dfs(depth + 1, sum);
    }
}
