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
        double[] arr = new double[n];
        for(int i=0; i<n; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }
        double max = 0.0;
        double[] dp = new double[n];
        dp[0] = arr[0];
        for(int i=1; i<n; i++){
            dp[i] = Math.max(arr[i], dp[i-1]*arr[i]);
            max = Math.max(dp[i],max);
        }
        System.out.println(String.format("%.3f",max));
    }
}

