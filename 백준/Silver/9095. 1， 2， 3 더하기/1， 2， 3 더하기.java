import java.util.*;
import java.io.*;

class Main {
  static int[] dp = new int[11];
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(st.nextToken());
    dp[0] = 1; // 0을 만들 수 있는 경우는 1가지(아무것도 선택하지 않는 경우)
    dp[1] = 1; // 1을 만들 수 있는 경우는 1가지(1을 선택하는 경우)
    dp[2] = 2; // 2를 만들 수 있는 경우는 2가지(1+1, 2를 선택하는 경우)
    for(int i=3; i<11; i++){
      dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    }
    for(int i=0; i<n; i++){
      int a = Integer.parseInt(br.readLine());
      System.out.println(dp[a]);
    }
  }

}