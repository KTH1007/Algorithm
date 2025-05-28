import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        dfs(a, b, 0L);

        System.out.println(count);
    }

    private static void dfs(int a, int b, long num) {
        if (num > b) {
            return;
        }
        if (num >= a) {
            count++;
        }

        dfs(a, b, num * 10 + 4);
        dfs(a, b, num * 10 + 7);
    }
}
