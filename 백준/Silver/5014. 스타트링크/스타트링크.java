import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int f,s,g,u,d;
    static int count = 0;
    static int[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());  // 층 수
        s = Integer.parseInt(st.nextToken());  // 현재위치
        g = Integer.parseInt(st.nextToken());  // 목표 층
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        visited = new int[f+1];
        count = BFS();
        if(count != -1)
            System.out.println(count);
        else System.out.println("use the stairs");
    }
    static int BFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = 1;
        while (!queue.isEmpty()){
            int current = queue.poll();
            if(current == g)
                return visited[current] - 1;
            if(current + u <= f && visited[current+u] == 0){
                visited[current+u] = visited[current]+1;
                queue.add(current+u);
            }
            if(current-d > 0 && visited[current-d] == 0){
                visited[current-d] = visited[current] + 1;
                queue.add(current-d);
            }

        }
        return -1;
    }
}
