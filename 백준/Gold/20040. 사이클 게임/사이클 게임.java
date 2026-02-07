import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);

            if (union(a, b)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }

    private static boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x == y) {
            return true;
        }

        if (x <= y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }

        return false;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return find(parent[x]);
        }
    }
}
