import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int a, b, n, m;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] count;
    static boolean flag = false;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        count = new int[n + 1];
        Arrays.fill(count, Integer.MAX_VALUE);
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }
        BFS();
        if(flag)
            System.out.println(count[b]);
        else System.out.println(-1);

    }
    static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = true;
        count[a] = 0;
        while (!queue.isEmpty()){
            int c = queue.poll();
            if(c == b){
                flag = true;
                return;
            }
            for(int i=0; i<list.get(c).size(); i++){
                int next = list.get(c).get(i);
                if(visited[next])
                    continue;
                visited[next] = true;
                queue.add(next);
                count[next] = count[c]+1;
            }
        }
    }
}
