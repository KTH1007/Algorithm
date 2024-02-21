import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long num = 1;

        for (int i = 1; i <= n; i++) {
            num *= i;
        }

        long answer = ((((num / 60) / 60) / 24) / 7);
        System.out.println(answer);
    }

}
