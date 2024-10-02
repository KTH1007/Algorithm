import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int start = 0;

        while (start < n) {
            int sum = 0;
            for (int i = start; i < n; i++) {
                sum += arr[i];
                if (sum == m) {
                    count++;
                    break;
                }
                if (sum > m) {
                    break;
                }
            }
            start++;
        }

        System.out.println(count);

    }
}
