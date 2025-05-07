import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = 0;

        int[] colors = new int[m];
        for (int i = 0; i < m; i++) {
            colors[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, colors[i]);
        }

        while (left < right) {
            int mid = (left + right) / 2;

            int sum = 0;
            for (int color : colors) {
                if (color % mid == 0) {
                    sum += color / mid;
                } else {
                    sum += color / mid + 1;
                }
            }

            if (sum > n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left);
    }
}
