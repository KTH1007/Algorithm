import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] sum = new long[n];
        sum[1] = arr[0];

        for (int i = 2; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            total += sum[i] * arr[i];
        }

        System.out.println(total);
    }
}
