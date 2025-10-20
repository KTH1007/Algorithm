import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0, 0);
        System.out.println(count);
    }

    private static void dfs(int depth, int answer, int prev1, int prev2) {
        if (depth == 10) {
            if (answer >= 5) {
                count++;
            }
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (depth >= 2 && prev1 == i && prev2 == i) {
                continue;
            }

            if (arr[depth] == i) {
                dfs(depth + 1, answer + 1, i, prev1);
            } else if (arr[depth] != i) {
                dfs(depth + 1, answer, i, prev1);
            }
        }
    }
}
