import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static boolean[] visited;
    static int[] arr;
    static int last;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=1; i<=n; i++){
            visited[i] = true;
            last = i;
            DFS(i);
            visited[i] = false;
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

    }
    static void DFS(int i){
        if(!visited[arr[i]]){
            visited[arr[i]] = true;
            DFS(arr[i]);
            visited[arr[i]] = false;
        }
        if(arr[i] == last)
            list.add(arr[i]);
    }

}