import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        Arrays.sort(arr);

        int value = Integer.MAX_VALUE;
        int start = 0;
        int end = n - 1;

        int x = 0;
        int y = 0;

        while (start < end) {
            int num = arr[start] + arr[end];
            if (Math.abs(value) > Math.abs(num)) {
                value = num;
                x = arr[start];
                y = arr[end];
            }
            if (num == 0) {
                break;
            }
            if (num < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(x + " " + y);
    }
}
