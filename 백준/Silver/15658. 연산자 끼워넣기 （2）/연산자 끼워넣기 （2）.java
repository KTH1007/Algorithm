import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int[] op = new int[4];
    static int n;
    static int min;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        arr = new int[n];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        DFS(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void DFS(int depth, int sum){
        if(depth == n){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        for(int i=0; i<4; i++){
            if(op[i] == 0)
                continue;
            op[i]--;
            switch (i){
                case 0:
                    DFS(depth+1, sum + arr[depth]);
                    break;
                case 1:
                    DFS(depth+1, sum - arr[depth]);
                    break;
                case 2:
                    DFS(depth+1, sum * arr[depth]);
                    break;
                case 3:
                    DFS(depth+1, sum / arr[depth]);
                    break;
            }
            op[i]++;
        }
    }
}
