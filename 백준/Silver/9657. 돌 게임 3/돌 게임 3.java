import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
//        long[] dp = new long[1001];
//        //sk win = 1,  cy win = 0
//        dp[1] = 1; //sk1
//        dp[2] = 0; //sk1 cy1
//        dp[3] = 1; //sk3
//        dp[4] = 1; //sk4
//        dp[5] = 1; //sk3 cy1 sk1
//        dp[6] = 1; //sk4 cy1 sk1
//        dp[7] = 0; //sk1 cy4 sk1 cy1, sk3 cy4,  sk4 cy3
//
//        dp[8] = 1;//8   sk1, cy1, sk4, cy1, sk1
//        dp[9] = 0;
//        dp[10] = 1; // sk3, cy1, sk4, cy1, sk1
//        dp[11] = 1; //

        //7로 나누었을 때 나머지가 0이거나 2가 나오면 CY승
        if(n%7 == 0 || n%7 == 2)
            System.out.println("CY");
        else System.out.println("SK");
    }
}
