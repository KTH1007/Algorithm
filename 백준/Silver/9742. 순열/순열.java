import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String result;
    static boolean[] visited;
    static int totalCount;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            String temp = br.readLine();
            if (temp == null || temp.equals("")) break;

            st = new StringTokenizer(temp);
            String s = st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            visited = new boolean[s.length()];
            arr = new char[s.length()];

            result = "No permutation";
            totalCount = 0;

            dfs(0, s, n);

            sb.append(s).append(" ").append(n).append(" = ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int depth, String s, int n) {
        if (depth == s.length()) {
            totalCount++;
            if (totalCount == n) {
                String temp = "";
                for (int i = 0; i < arr.length; i++) {
                    temp += arr[i];
                }
                result = temp;
            }
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = s.charAt(i);
                dfs(depth + 1, s, n);
                visited[i] = false;
            }
        }
    }

}
