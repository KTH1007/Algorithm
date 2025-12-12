import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());

        int right = 2;
        int left = 1;
        StringBuilder sb = new StringBuilder();

        while (true) {
            long diff = (long) right * right - (long) left * left;

            if (diff == g) {
                sb.append(right).append("\n");
                right++;
            } else if (diff < g) {
                right++;
            } else {  // diff > g
                left++;
            }

            if (left >= right) break;
        }

        System.out.println(sb.length() == 0 ? "-1" : sb);
    }
}
