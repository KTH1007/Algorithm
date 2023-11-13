import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        init();
        for (int i = 0; i < n - 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for (int i = 2; i <= n; i++) {
            if (!isSameParent(1, i)) {
                System.out.println(1 + " " + i);
                return;
            }
        }
    }

    static void init() {
        for (int i = 0; i <= n; i++) parent[i] = i;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) parent[y] = x;
            else parent[x] = y;
        }
    }

    static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }


}
