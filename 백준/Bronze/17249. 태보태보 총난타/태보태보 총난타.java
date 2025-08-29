import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] input = br.readLine().split("0");

        final long lhs = input[0].chars().filter(n -> n == '@').count();
        final long rhs = input[1].chars().filter(n -> n == '@').count();

        System.out.print(lhs + " " + rhs);

    }
}