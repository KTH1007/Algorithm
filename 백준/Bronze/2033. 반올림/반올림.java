import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 1;

        if (n == 0) {
            System.out.println(0);
            return;
        }

        while (n > 0) {
            if (n < 10) {
                result *= n;
                break;
            }

            int temp = n % 10;
            int current = n / 10;

            if (temp >= 5) {
                current += 1;
            }

            n = current;
            result *= 10;

        }

        System.out.println(result);

    }
}
