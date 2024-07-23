import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int count;
    private static StringBuilder sb = new StringBuilder();
    private static StringBuilder sb2 = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (n >= i) {
                count = 0;
                sb2.setLength(0);
                maxCount(n, i);
                if (max < count) {
                    sb.setLength(0);
                    sb.append(sb2.toString());
                    max = count;
                }
            }
        }

        System.out.println(max);
        System.out.println(sb);
        br.close();
    }

    private static void maxCount(int n, int temp) {
        if (n < 0) {
            return;
        }
        sb2.append(n).append(" ");
        int diff = n - temp;
        n = temp;
        temp = diff;
        count++;
        maxCount(n, temp);
    }
}
