import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        visited = new boolean[n+1];
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        while (true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1)
                break;
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for(int i=1; i<=n; i++){
            visited = new boolean[n+1];
            BFS(i);
        }
        for(int i=1; i<=n; i++){
            min = Math.min(min, arr[i]);
        }
        int count = 0;
        for(int i=1; i<=n; i++){
            if(arr[i] == min){
                count++;
                sb.append(i).append(" ");
            }
        }
        System.out.println(min + " " + count);
        System.out.println(sb);

    }
    static void BFS(int a){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a,0});
        visited[a] = true;
        int count = 0;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i=0; i<list.get(current[0]).size(); i++){
                int next = list.get(current[0]).get(i);
                if(visited[next])
                    continue;
                queue.add(new int[]{next, current[1] + 1});
                visited[next] = true;
            }
            count = current[1];
        }
        arr[a] = count;
    }

}

