import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] arr;
    static int n, l, r, x;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        n = Integer.parseInt(tokens[0]);
        l = Integer.parseInt(tokens[1]);
        r = Integer.parseInt(tokens[2]);
        x = Integer.parseInt(tokens[3]);

        arr = new int[n];
        tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        dfs(new ArrayList<>(), 0);
        System.out.println(count);
    }

    private static void dfs(List<Integer> selected, int start) {
        if (selected.size() >= 2) {
            selected.sort((o1, o2) -> o1 - o2);
            int min = selected.get(0);
            int max = selected.get(selected.size() - 1);

            int sum = selected.stream()
                    .mapToInt(Integer::intValue)
                    .sum();

            if (sum >= l && sum <= r && (max - min) >= x) {
                count++;
            }
        }

        for (int i = start; i < n; i++) {
            selected.add(Integer.valueOf(arr[i]));
            dfs(selected, i + 1);
            selected.remove(Integer.valueOf(arr[i]));
        }
    }
}
