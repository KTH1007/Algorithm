import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        binarySearch(n, k, arr);
        System.out.println(result);
    }

    private static void binarySearch(int n, int k, int[] arr) {
        int left = arr[0];
        int right = arr[n - 1] + k;

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = compare(mid, arr);

            if (k >= sum) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    private static long compare(int mid, int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (mid > arr[i]) {
                sum += mid - arr[i];
            }
        }
        return sum;
    }
}
