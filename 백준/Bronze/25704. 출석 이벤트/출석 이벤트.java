import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        int result = p;

        if (n >= 5) {
            result = Math.min(result, p - 500);
        }
        if (n >= 10) {
            result = Math.min(result, p - (int) (p * 0.1));
        }
        if (n >= 15) {
            result = Math.min(result, p - 2000);
        }
        if (n >= 20) {
            result = Math.min(result, p - (int) (p * 0.25));
        }

        if (result >= 0) System.out.println(result);
        else System.out.println(0);
    }

}
