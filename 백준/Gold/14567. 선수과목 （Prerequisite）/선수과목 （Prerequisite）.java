import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] parentNum;
    static int[] answer;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parentNum = new int[n + 1];
        answer = new int[n+1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            parentNum[b]++;
        }
        BFS();
        for (int i = 1; i <= n; i++)
            System.out.print(answer[i] + " ");
    }

    static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(parentNum[i] == 0){
                queue.add(i);
                answer[i] = 1;
            }
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < list.get(current).size(); i++) {
                int next = list.get(current).get(i);
                parentNum[next]--;
                if(parentNum[next] == 0){
                    queue.add(next);
                    answer[next] = answer[current] + 1;
                }
            }
        }
    }


}
