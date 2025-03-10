import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (i + sum == n) {
                result = i;
                break;
            }
        }

        System.out.println(result);

    }
}
