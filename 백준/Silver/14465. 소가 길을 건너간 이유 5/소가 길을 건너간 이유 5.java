import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] stoplight = new boolean[n];
        Arrays.fill(stoplight, true);

        for (int i = 0; i < b; i++) {
            int num = Integer.parseInt(br.readLine());
            stoplight[num - 1] = false;
        }

        int left = 0;
        int right = left + k - 1;

        int count = 0;
        for (int i = 0; i <= right; i++) {
            if (!stoplight[i]) count++;
        }

        min = Math.min(min, count);

        while (left < n - k) {
            if (!stoplight[left] && count > 0) count--;
            left++;
            right++;
            if (!stoplight[right]) count++;

            min = Math.min(min, count);
        }

        System.out.println(min);
    }

}
