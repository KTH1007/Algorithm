import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long count = 0;

        for (int i = 0; i < n - 1; i++) {
            int num = arr[i];

            if (num >= 0.9 * arr[i + 1]) {
                int index = upperBound(num, i, arr);
                count += (index - i);
            }
        }

        System.out.println(count);
    }

    private static int upperBound(int num, int i, int[] arr) {
        int left = i + 1;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] * 0.9 <= num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }
}
