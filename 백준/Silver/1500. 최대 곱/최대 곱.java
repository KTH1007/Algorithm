import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int N = 10000000;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int quotient = s / n;
        int remainder = s % n;

        int[] arr = new int[n];

        Arrays.fill(arr, quotient);
        for (int i = 0; i < remainder; i++) {
            arr[i] = quotient + 1;
        }

        long mul = 1;
        for (int i : arr) {
            mul *= i;
        }

        System.out.println(mul);
    }
}
