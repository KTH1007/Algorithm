import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long[] arr = new long[s];
        long sum = 0;
        for (int i = 0; i < s; i++) {
            arr[i] = Long.parseLong(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);
        long max = arr[arr.length - 1];

        long mid = binarySearch(arr, c);

        long answer = sum - (mid * c);

        System.out.println(answer);
    }

    private static long binarySearch (long[] arr, int c) {
        long left = 1;
        long right = arr[arr.length - 1];
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / mid;
            }

            if (count >= c) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
