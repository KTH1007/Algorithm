import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int max = Integer.MIN_VALUE;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                if (i > 0 && arr[i] + arr[i - 1] > arr[i]) arr[i] += arr[i - 1];
                max = Math.max(max, arr[i]);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }


}
