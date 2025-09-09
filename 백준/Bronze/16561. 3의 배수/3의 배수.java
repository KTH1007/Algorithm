import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0, sum = 0;

        for (int i = 1; i < n / 3; i++) {
            for (int j = 1; j < n / 3; j++) {
                sum = 3 * i + 3 * j;
                if (n - sum > 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}