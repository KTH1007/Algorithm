import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, delete, count = 0;
    static int[] node;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = new int[n];
        visited = new boolean[n];
        int root = 0;
        for (int i = 0; i < n; i++) {
            node[i] = Integer.parseInt(st.nextToken());
            if (node[i] == -1) root = i;
        }
        delete = Integer.parseInt(br.readLine());
        deleteNode(delete);
        countLeaf(root);
        System.out.println(count);
    }

    static void deleteNode(int d) {
        node[d] = -2;
        for (int i = 0; i < n; i++) {
            if (node[i] == d) deleteNode(i);
        }
    }

    static void countLeaf(int c) {
        boolean isLeaf = true;
        visited[c] = true;
        if (node[c] != -2) {
            for (int i = 0; i < n; i++) {
                if (node[i] == c && !visited[i]) {
                    countLeaf(i);
                    isLeaf = false;
                }
            }
            if (isLeaf) count++;
        }
    }


}