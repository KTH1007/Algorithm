import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int max = 0;
    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] num = new int[arr[arr.length - 1] + 1];
        for (int i = 0; i <= arr[arr.length - 1]; i++) {
            num[i] = i;
        }

        int m = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum <= m) max = arr[arr.length - 1];
        search(m);
        System.out.println(max);
    }

    private static void search(int m) {
        int left = 0;
        int right = arr[arr.length - 1];

        while (left < right) {
            int mid = (left + right) / 2;
            int temp = check(mid);
            if (temp > m) {
                right = mid;
            } else {
                max = Math.max(max, mid);
                left = mid + 1;
            }
        }
    }

    private static int check(int n) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > n) result += n;
            else result += arr[i];
        }

        return result;
    }

}
