import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final long div = 1000000007;
    static int n;
    static int count = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long[][] dp = new long[n+1][8];
        dp[0][0] = 1;
        /*
        0 정보과학관
        1 진선관
        2 미래관
        3 신양관
        4 진리관
        5 환경직기념관
        6 학생회관
        7 형남공학관
         */
        for(int i=1; i<=n; i++){
            //0번째 건물에 위치했을 때
            dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % div;
            //1번째 건물에 위치했을 떄
            dp[i][1] = (dp[i-1][0] + dp[i-1][2] + dp[i-1][3]) % div;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][3] + dp[i-1][5]) % div;
            dp[i][3] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][4] + dp[i-1][5]) % div;
            dp[i][4] = (dp[i-1][3] + dp[i-1][5] + dp[i-1][6]) % div;
            dp[i][5] = (dp[i-1][2] + dp[i-1][3] + dp[i-1][4] + dp[i-1][7]) % div;
            dp[i][6] = (dp[i-1][4] + dp[i-1][7]) % div;
            dp[i][7] = (dp[i-1][5] +dp[i-1][6]) % div;
        }
        System.out.println(dp[n][0]);


    }
}
