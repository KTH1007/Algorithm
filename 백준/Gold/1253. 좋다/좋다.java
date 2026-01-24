import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            search(arr, arr[i], i);
        }

        System.out.println(count);
    }

    private static void search(int[] arr, int num, int position) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            if (left == position) {
                left++;
            } else if (right == position) {
                right--;
            }

            if (left >= right) {
                return;
            }

            int sum = arr[left] + arr[right];

            if (sum == num) {
                count++;
                return;
            }

            if (sum > num) {
                right--;
            } else if (sum < num) {
                left++;
            }
        }
    }
}
