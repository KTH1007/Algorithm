import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        long sum = 0;

        for (int i = 0; i < 5; i++) {
            long n = s.charAt(i) - '0';
            sum += Math.pow(n, 5);
        }

        System.out.println(sum);
    }
}
