import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int n;
    static int[] arr = {1, 5, 10, 50};
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        simulate(0, 0, 0);
        System.out.println(set.size());
    }

    private static void simulate(int depth, int sum, int idx) {
        if (depth == n) {
            set.add(sum);
            return;
        }
        for (int i = idx; i < 4; i++) {
            simulate(depth + 1, sum + arr[i], i);
        }
    }
}
