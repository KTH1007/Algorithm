import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        int[] dpInc = new int[n];

        for (int i = 0; i < n; i++) {
            dpInc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dpInc[i] = Math.max(dpInc[i], dpInc[j] + 1);
                }
            }
        }

        int[] dpDec = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            dpDec[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    dpDec[i] = Math.max(dpDec[i], dpDec[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dpInc[i] + dpDec[i] - 1);
        }

        System.out.println(max);
    }
}
