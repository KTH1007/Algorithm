import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] check = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int n = d(i);

            if (n < 10001) {
                check[n] = true;
            }
        }

        for (int i = 1; i < 10001; i++) {
            if (!check[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);

    }

    public static int d(int n) {
        int sum = n;

        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}
