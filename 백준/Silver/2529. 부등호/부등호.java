import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static char[] arr;
    static boolean[] visited;
    static List<String> result = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n];
        visited = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        dfs(0, "");
        Collections.sort(result);
        System.out.println(result.get(result.size() - 1));
        System.out.println(result.get(0));
    }

    static void dfs(int depth, String num) {
        if (depth == n + 1) {
            result.add(num);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (depth == 0 || !visited[i] && compare(num.charAt(num.length() - 1) - '0', i, arr[depth - 1])) {
                visited[i] = true;
                dfs(depth + 1, num + i);
                visited[i] = false;
            }
        }

    }

    static boolean compare(int a, int b, char c) {
        if (c == '<') return a < b;
        else return a > b;
    }


}
