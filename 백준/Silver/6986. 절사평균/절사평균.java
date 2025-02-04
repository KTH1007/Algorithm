import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(arr);

        double sum = 0;
        double sum2 = 0;

        for (int i = k; i < n - k; i++) {
            sum += arr[i];
            sum2 += arr[i];
        }

        for (int i = 0; i < k; i++) {
            sum2 += arr[k];
        }
        for (int i = n - k; i < n; i++) {
            sum2 += arr[n - k - 1];
        }

        double avg = (sum / (n - (k * 2)) + 1e-8);
        double avg2 = sum2 / n + 1e-8;

        System.out.println(String.format("%.2f", avg));
        System.out.println(String.format("%.2f", avg2));

    }
}
