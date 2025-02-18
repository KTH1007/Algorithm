import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());

            long left = 0;
            long right = 1_000_000_000L;
            long result = 0;

            while (left <= right) {
                long mid = (left + right) / 2;
                long sum = (mid * (mid + 1)) / 2; // 등차 수열 합 공식

                if (sum <= n) {
                    result = Math.max(result, mid);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

}
