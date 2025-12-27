import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        int n = Integer.parseInt(tokens[0]);
        int s = Integer.parseInt(tokens[1]);

        int[] arr = new int[n];

        tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        int[] sum = new int[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        int count = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (sum[i] >= s) {
                count = Math.min(count, i + 1);
            }
        }

        int left = 0;
        int right = 1;

        while (right < sum.length) {
            int num = sum[right] - sum[left];

            if (num >= s) {
                count = Math.min(count, right - left);
                left++;
            } else {
                right++;
            }
        }

        if (count == Integer.MAX_VALUE) {
            count = 0;
        }
        System.out.println(count);
    }
}
