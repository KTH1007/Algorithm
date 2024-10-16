import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long length = countLength(n);
        System.out.println(length);
    }

    static long countLength(int n) {
        int length = 0;
        int num = 10;
        int count = 1;

        for (int i = 1; i <= n; i++) {
            if (i % num == 0) {
                num *= 10;
                count++;
            }
            length += count;
        }

        return length;
    }
}
