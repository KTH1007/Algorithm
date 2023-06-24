import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int destination,distance,count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        BFS();
        System.out.println(destination +" " + distance +" " + count);
    }
    static void BFS(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 0});  //번호, 거리
        visited[1] = true;
        while (!queue.isEmpty()){
            int[] current = queue.poll();

            if(current[1] > distance){
                distance = current[1];
                destination = current[0];
                count = 1;
            }
            else if(current[1] == distance){
                if(destination > current[0])
                    destination = current[0];
                count++;
            }
            for(int i=0; i<list.get(current[0]).size(); i++){
                int next = list.get(current[0]).get(i);
                if(visited[next])
                    continue;
                visited[next] =true;
                queue.add(new int[]{next, current[1]+1});
            }
        }
    }
}

