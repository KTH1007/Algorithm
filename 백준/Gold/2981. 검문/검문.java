import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int gcd = arr[1] - arr[0];
        for (int i = 2; i < n; i++) {
            gcd = gcd(arr[i] - arr[i - 1], gcd);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= gcd; i++) {
            if (gcd % i == 0) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}
