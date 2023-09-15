import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /**
         * 1 = cy  1
         * 2 = sk  1  1
         * 3 = cy  1  1  1
         * 4 = sk  3  1
         * 5 = sk  4  1
         * 6 = sk  3  1  1  1
         * 7 = sk  4  1  1  1
         */
        if ((n % 7) == 1 || (n % 7) == 3) {
            System.out.println("CY");
        } else System.out.println("SK");

    }


}