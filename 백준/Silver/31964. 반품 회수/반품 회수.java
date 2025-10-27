import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int[] x;
    static int[] t;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        x = new int[n];
        t = new int[n];

        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(tokens[i]);
        }

        tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(tokens[i]);
        }

        int time = x[n - 1]; // 맨 뒤에서 시작
        for (int i = n - 1; i >= 0; i--) {
            if (i != n - 1) {
                time += x[i + 1] - x[i];
            }

            if (time < t[i]) {
                time += (t[i] - time);
            }
        }

        time += x[0];

        System.out.println(time);
    }
}
