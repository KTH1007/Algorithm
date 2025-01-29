import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int num;
    static String[] list, arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        String s = br.readLine();
        num = Integer.parseInt(s);
        n = s.length();
        visited = new boolean[n];
        list = new String[n];
        arr = new String[n];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = Character.toString(s.charAt(i));
        }

        dfs(0);

        if (min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            String answer = "";
            for (String s : list) {
                answer += s;
            }
            if (Integer.parseInt(answer) > num) {
                min = Math.min(min, Integer.parseInt(answer));
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

}
