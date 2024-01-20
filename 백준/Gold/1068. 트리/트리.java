import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] node;
    static int n;
    static int count = 0;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        node = new int[n];
        visited = new boolean[n];

        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            node[i] = Integer.parseInt(st.nextToken());
            if (node[i] == -1) root = i;
        }

        int delete = Integer.parseInt(br.readLine());

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
                if (node[i] == c && !visited[i]) { //현재 노드를 부모로 가지고 있는 노드가 있으면 탐색
                    countLeaf(i);
                    isLeaf = false;
                }
            }
            if (isLeaf) count++;
        }
    }


}
