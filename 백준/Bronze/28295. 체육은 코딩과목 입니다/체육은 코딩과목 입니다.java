import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = 0;
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 1) {
                x += 90;
                x %= 360;
            } else if (n == 2) {
                x += 180;
                x %= 360;
            } else {
                x -= 90;
                if (x < 0) x = 270;
            }
        }

        if (x == 0) System.out.println("N");
        else if (x == 90) System.out.println("E");
        else if (x == 180) System.out.println("S");
        else System.out.println("W");
    }

}
