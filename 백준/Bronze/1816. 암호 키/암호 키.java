import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        int minValue = (int) Math.pow(10, 6);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String result = "YES";
            for (int j = 2; j <= minValue; j++) {
                if (arr[i] % j == 0) result = "NO";
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
