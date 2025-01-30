import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) * 2 + 1;

        int[] arr = new int[1000001];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            arr[x] = g;
        }

        int max = 0;
        int sum = 0;

        for (int i = 0; i < 1000001; i++) {
            if (i - k >= 0) sum -= arr[i - k];
            sum += arr[i];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

}
