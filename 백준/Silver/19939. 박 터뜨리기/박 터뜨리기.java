import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        int min = fac(k);

        if (min > n) {
            System.out.println(-1);
            return;
        }

        init(k, arr);
        n -= min;

        int temp = n / k;
        arrangement(k, arr, temp);

        temp = n % k;
        int i = 0;
        while (temp-- > 0) {
            arr[i++]++;
        }

        System.out.println(arr[0] - arr[k - 1]);
    }

    private static void arrangement(int k, int[] arr, int temp) {
        for (int i = 0; i < k; i++) {
            arr[i] += temp;
        }
    }

    private static void init(int k, int[] arr) {
        for (int i = 0; i < k; i++) {
            arr[i] = k - i;
        }
    }

    private static int fac(int k) {
        int num = 0;
        for (int i = 1; i <= k; i++) {
            num += i;
        }
        return num;
    }
}
