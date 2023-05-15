import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int s;
    static int[] arr;
    static boolean[] visited;
    static int count;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count = 0;
        DFS(0, 0);
        if(s == 0)
            count -= 1;
        System.out.println(count);
    }
    static void DFS(int depth, int sum){
        if(depth == n){
            if(sum == s)
                count++;
            return;
        }
        DFS(depth + 1, sum); // 해당 인덱스를 더하지 않는 경우
        DFS(depth + 1, sum + arr[depth]); //해당 인덱스를 더하는 경우
    }
}
