import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int a,b,n,m;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        BFS(n);
        System.out.println(count);
    }
    static void BFS(int v){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{v,count});
        visited[v] = true;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            if(current[0] == m){
                count = current[1];
                return;
            }
            if(current[0] + 1 <= 100000 && !visited[current[0] + 1]){
                visited[current[0]+1] = true;
                queue.add(new int[]{current[0]+1,current[1]+1});
            }
            if(current[0] - 1 >= 0 && !visited[current[0] - 1]){
                visited[current[0]-1] = true;
                queue.add(new int[]{current[0]-1,current[1]+1});
            }
            if(current[0] + a <= 100000 && !visited[current[0] + a]){
                visited[current[0]+a] = true;
                queue.add(new int[]{current[0]+a,current[1]+1});
            }
            if(current[0] - a >= 0 && !visited[current[0] - a]){
                visited[current[0]-a] = true;
                queue.add(new int[]{current[0]-a,current[1]+1});
            }
            if(current[0] + b <= 100000 && !visited[current[0] + b]){
                visited[current[0]+b] = true;
                queue.add(new int[]{current[0]+b,current[1]+1});
            }
            if(current[0] - b >= 0 && !visited[current[0] - b]){
                visited[current[0]-b] = true;
                queue.add(new int[]{current[0]-b,current[1]+1});
            }
            if(current[0] * a <= 100000 && !visited[current[0] * a]){
                visited[current[0]*a] = true;
                queue.add(new int[]{current[0]*a,current[1]+1});
            }
            if(current[0] * b <= 100000 && !visited[current[0] * b]){
                visited[current[0]*b] = true;
                queue.add(new int[]{current[0]*b,current[1]+1});
            }

        }
    }
}

