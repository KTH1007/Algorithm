import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static int last = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            last = i;
            visited[i] = true;
            dfs(i);
            visited[i] = false;
        }

        StringBuilder sb = new StringBuilder();

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (int i = 0; i < list.size(); i++) sb.append(list.get(i)).append("\n");

        System.out.println(sb);


    }

    static void dfs(int i) {
        if (!visited[arr[i]]) {
            visited[arr[i]] = true;
            dfs(arr[i]);
            visited[arr[i]] = false;
        }
        if (last == arr[i]) {
            list.add(last);
        }
    }

}
