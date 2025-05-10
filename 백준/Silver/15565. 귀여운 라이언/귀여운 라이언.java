import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int count = 0;

        int min = Integer.MAX_VALUE;
        while (right <= n) {
            if (count == k) {
                min = Math.min(min, right - left);
            }

            if (count < k) {
                if (arr[right] == 1) count++;
                right++;
            } else {
                if (arr[left] == 1) count--;
                left++;
            }
        }

        if (min == Integer.MAX_VALUE) min = -1;

        System.out.println(min);
    }

}
