import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[] visited = new int[100001];
    static int second = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        second = BFS();
        System.out.println(second);
    }
    static int BFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 1;
        while (!queue.isEmpty()){
            int current = queue.poll();
            if(current == m)
                return visited[current] - 1;
            if(current-1 >=0 && visited[current-1] == 0){
                visited[current-1] = visited[current] + 1;
                queue.add(current-1);
            }
            if(current+1 <= 100000 && visited[current+1] == 0){
                visited[current+1] = visited[current]+1;
                queue.add(current+1);
            }
            if(current*2 <= 100000 && visited[current*2] == 0){
                visited[current*2] = visited[current]+1;
                queue.add(current*2);
            }
        }
        return -1;
    }
}
