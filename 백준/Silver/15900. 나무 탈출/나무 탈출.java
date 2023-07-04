import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int answer = 0;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        DFS(1,0);
        if(answer % 2 != 0)
            System.out.println("Yes");
        else System.out.println("No");
    }
    static void DFS(int v, int count){
        visited[v] = true;
        for(int i=0; i<list.get(v).size(); i++){
            int next = list.get(v).get(i);
            if(visited[next])
                continue;
            DFS(next, count+1);
        }
        if(list.get(v).size() == 1)
            answer += count;
    }
}
