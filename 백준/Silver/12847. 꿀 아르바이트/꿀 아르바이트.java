import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long max = 0;
        long sum = 0;

        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }

        max = sum;

        for (int i = 0; i < n - m - 1; i++) {
            sum -= arr[i];
            sum += arr[i + m];

            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

}
