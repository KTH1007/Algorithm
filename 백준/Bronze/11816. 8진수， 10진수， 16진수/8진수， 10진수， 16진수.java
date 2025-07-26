import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(br.readLine()));
    }

    private static String solution(String input) {
        int radix = 10;
        if (input.startsWith("0x")) {
            input = input.substring(2);
            radix = 16;
        } else if (input.startsWith("0")) {
            input = input.substring(1);
            radix = 8;
        }
        return new BigInteger(input, radix).toString();
    }

}