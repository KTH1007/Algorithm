import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        boolean[] num = new boolean[1000001]; // false = 소수
        num[0] = num[1] = true;

        for (int i = 2; i * i < 1000001; i++) {
            if (!num[i]) {
                for (int j = i * i; j < 1000001; j += i) {
                    num[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int count;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            count = 0;

            for (int i = 2; i <= n / 2; i++) {
                if (!num[i] && !num[n - i]) count++;
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
