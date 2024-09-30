import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int temp = n;
        int max = Integer.MIN_VALUE;

        while (temp-- > 0) {
            max = Math.max(max, (n - temp) * arr[temp]);
        }
        System.out.println(max);
    }
}
