import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static boolean flag = false;
    static int n;
    static int k;
    static int count = 0;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        visited = new boolean[n];
        DFS(0, 0);
        if(!flag)
            System.out.println(-1);
    }
    static void DFS(int depth, int num){
        if(num > n){
            return;
        }
        if(num == n){
            count++;
            if(count == k){
                flag = true;
                for(int i=0; i<depth-1; i++){
                    System.out.print(dp[i]+"+");
                }
                System.out.print(dp[depth-1]);
            }
            return;
        }
        for(int i=1; i<4; i++){
            dp[depth] = i;
            DFS(depth+1, num+i);
        }
    }


}
