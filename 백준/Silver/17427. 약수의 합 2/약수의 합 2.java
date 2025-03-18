import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += i * (n / i);
        }
        System.out.println(answer);
    }

}
