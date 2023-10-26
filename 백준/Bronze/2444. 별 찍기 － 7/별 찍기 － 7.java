import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i + i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();

        }

        for (int i = n - 1; i > 0; i--) {
            for (int j = n - i; j > 0; j--)
                System.out.print(" ");
            for (int j = 1; j <= i + i - 1; j++)
                System.out.print("*");
            System.out.println();
        }
    }

}
