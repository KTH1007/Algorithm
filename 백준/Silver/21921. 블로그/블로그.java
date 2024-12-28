import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max = 0;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;

        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }
        check(sum);

        int i = 0;
        int j = x;

        while (j < n) {
            sum = sum - arr[i] + arr[j];
            check(sum);
            i++;
            j++;
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(count);
    }

    private static void check(int sum) {
        if (sum > max) {
            max = sum;
            count = 1;
        } else if (sum == max) count++;
    }

}
