import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result1 = 0;
        int result2 = 0;
        int result3 = 0;

        for (int i = 1; i <= n; i++) {
            result1 += i;
        }
        result2 = (int) Math.pow(result1, 2);
        for (int i = 1; i <= n; i++) {
            result3 += Math.pow(i, 3);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result1).append("\n").append(result2).append("\n").append(result3);
        System.out.println(sb);
    }
}
