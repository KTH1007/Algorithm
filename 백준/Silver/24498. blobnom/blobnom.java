import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Math.max(arr[0], arr[n - 1]);
        for (int i = 1; i < n - 1; i++) {
            if (arr[i - 1] > 0 && arr[i + 1] > 0) {
                int min = Math.min(arr[i - 1], arr[i + 1]);
                max = Math.max(max, arr[i] + min);
            }
        }

        System.out.println(max);
    }
}
