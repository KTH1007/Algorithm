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

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch(arr, m));
    }

    private static long binarySearch(int[] arr, int m) {
        long left = 0;
        long right = 1000000000000L;
        long answer = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid, arr, m)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return answer;
    }

    private static boolean check(long mid, int[] arr, int m) {
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += mid / arr[i];
        }

        return count >= m;
    }
}
