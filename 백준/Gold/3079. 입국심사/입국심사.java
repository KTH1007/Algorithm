import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(time);

        System.out.println(binarySearch(time, n, m));
    }

    private static long binarySearch(int[] time, int n, int m) {
        long left = 0;
        long right = (long) time[n - 1] * m;

        while (left < right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < n; i++) {
                count += mid / time[i];
                if (count >= m) break;
            }
            if (count < m) {
                left = mid + 1;
            } else if (count >= m) {
                right = mid;
            }
        }

        return left;
    }
}
