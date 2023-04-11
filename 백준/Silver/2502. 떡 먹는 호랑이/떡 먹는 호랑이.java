import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[d];
        loopout:
        for(int i=1; i<k/2; i++) {  //k/2라고 정한 이유는 a값이 k/2인 경우 나머지 값은 b에서 더하기 때문
            for(int j=i+1; j<k; j++){ //j(b) 값은 a보다 커야 함
                dp[0] = i;
                dp[1] = j;
                for(int l = 2; l<d; l++){
                    dp[l] = dp[l-1] + dp[l-2];
                }
                if(dp[d-1] == k){
                    System.out.println(dp[0]);
                    System.out.println(dp[1]);
                    break loopout;
                }
            }
        }

    }
}
