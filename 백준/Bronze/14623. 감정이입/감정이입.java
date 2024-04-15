import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long a = Integer.parseInt(br.readLine(), 2);
        long b = Integer.parseInt(br.readLine(), 2);

        System.out.println(Long.toString(a * b, 2));
    }
}
