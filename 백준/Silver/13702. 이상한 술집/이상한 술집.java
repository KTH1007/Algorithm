import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int N = 10000000;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] kettle = new int[n];
        for (int i = 0; i < n; i++) {
            kettle[i] = Integer.parseInt(br.readLine());
        }
        
        if (n == k) {
            System.out.println(kettle[0]);
            return;
        }

        Arrays.sort(kettle);
        long max = 0;

        long left = 0;
        long right = kettle[n - 1];

        while (left < right) {
            long mid = (left + right) / 2;

            long count = 0;
            for (int i = 0; i < n; i++) {
                count += kettle[i] / mid;
            }

            if (count >= k) {
                max = Math.max(max, mid);
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(max);
    }
}
